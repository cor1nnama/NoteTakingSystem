package data_access;

import entity.Notebook;
import entity.NotebookFactory;
import entity.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class FileNotebookDataAccessObject implements NotebookDataAccessInterface{
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, List<Notebook>> notebookMap = new HashMap<>();

    private NotebookFactory notebookFactory;


    public FileNotebookDataAccessObject(String csvPath, NotebookFactory notebookFactory) throws IOException {
        this.notebookFactory = notebookFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("notebook", 1);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username,notebook");

/**                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String notebookName = String.valueOf(col[headers.get("notebook")]);
                    if (userDAO.existsByName(username)){
                        for (String username1:headers.keySet()){
                            Map<String, User> accounts = userDAO.getUser(username1);
                        }
                        User user = accounts.get(username);
                        Notebook notebook = notebookFactory.create(notebookName, user.getUsername());
                        notebookMap.put(notebookName, notebook);
                    }
                }
 */
            }
        }
    }

    @Override
    public void save(String username, Notebook notebook) {
        List<Notebook> notebookList = notebookMap.get(username);
        notebookList.add(notebook);
        notebookMap.put(username, notebookList);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (List<Notebook> notebookList : notebookMap.values()) {
                for (Notebook notebook: notebookList){
                    String line = String.format(notebook.getName());
                    writer.write(line);
                    writer.newLine();
                }
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<LocalDateTime, String> getNotebook() {

    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String notebookName) {
        return notebookMap.containsKey(notebookName);
    }
}
