package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommonUser implements User{

    // this class is the user of all note-taking system

    public String username;
    public String password;
    public Map<LocalDateTime, String> notebooks;
    public Trash trash;

    public CommonUser(String username, String password){
        this.username = username;
        this.password = password;
        this.notebooks = new HashMap<>();
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
    public Map<LocalDateTime, String> getNotebooks() {
        return notebooks;
    }

    @Override
    public void setNotebooks(Map<LocalDateTime, String> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String getUsername(){return this.username;}

    @Override
    public String getPassword(){return this.password;}

    @Override
    public void renameNotebook(LocalDateTime notebookID) {

    }

    public void addNotebook(Notebook notebook) {
        this.notebooks.put(notebook.getCreationTime(), notebook.name);
    }

    public void removeNotebook(LocalDateTime notebookID) {
        notebooks.remove(notebookID);
    }
}
