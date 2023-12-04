package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommonUser implements User{

    // this class is the user of all note-taking system

    public String username;
    public String password;
    public ArrayList<LocalDateTime> notebooks;
    public Trash trash;

    public CommonUser(String username, String password){
        this.username = username;
        this.password = password;
        this.notebooks = new ArrayList<>();
        this.trash = new Trash();
    }
    @Override
    public void setUsername(String newName) {
        this.username = newName;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public ArrayList<LocalDateTime> getNotebooks() {
        return notebooks;
    }

    @Override
    public void setNotebooks(ArrayList<LocalDateTime> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String getUsername(){return this.username;}

    @Override
    public String getPassword(){return this.password;}

    public void addNotebook(Notebook notebook) {
        this.notebooks.add(notebook.getCreationTime());
    }
}
