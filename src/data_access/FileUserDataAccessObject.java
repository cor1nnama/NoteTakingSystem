package data_access;

import entity.Note;
import entity.User;
import entity.UserFactory;
import use_case.user_end.Notebook.NotebookUserDataAccessInterface;
import use_case.user_end.login.LoginUserDataAccessInterface;
import use_case.user_end.signup.UserSignupDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements UserSignupDataAccessInterface, LoginUserDataAccessInterface, NotebookUserDataAccessInterface {
    private final File usersFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;
    private FileOutputStream fsOut;
    private FileInputStream fsIn;
    private ObjectOutputStream osOut;
    private ObjectInputStream osIn;

    public FileUserDataAccessObject(String usersPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;
        usersFile = new File(usersPath);
        fsOut = new FileOutputStream(usersPath);
        osOut = new ObjectOutputStream(fsOut);
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(User user) throws IOException {
        accounts.put(user.getUsername(), user);
        this.writeToFile();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    public void writeToFile() throws IOException {
        new FileOutputStream(usersFile).close(); //Clears file for fresh data

        fsOut = new FileOutputStream(usersFile);
        osOut = new ObjectOutputStream(fsOut);

        for (String username : accounts.keySet()) {
            osOut.writeObject(accounts.get(username));
        }

        osOut.close();
        fsOut.close();
    }

    public void readFromFile() throws IOException {
        fsIn = new FileInputStream(usersFile);
        osIn = new ObjectInputStream(fsIn);

        try {
            while (true) { //alternatively (osIn.available() > 0)
                User userToAdd = (User) osIn.readObject();
                accounts.put(userToAdd.getUsername(), userToAdd);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException ignored) {
        }

        osIn.close();
        fsIn.close();

    }



    public boolean authenticateUser(String providedUsername, String providedPassword){
        User user = accounts.get(providedUsername);
        return user.getPassword().equals(providedPassword);
    }

}
