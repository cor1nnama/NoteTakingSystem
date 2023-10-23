package entity;

import java.util.ArrayList;

public class CommonUser implements User{

    // this class is the user of all note-taking system

    public String username;
    public String password;
    public ArrayList<Notebook> notebook;
    public Trash trash;

    public CommonUser(String username, String password){
        this.username = username;
        this.password = password;
        this.notebook = new ArrayList<Notebook>();
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

    public void setNotebook(ArrayList<Notebook> notebook) {
        this.notebook = notebook;
    }

    public ArrayList<Notebook> getNotebook() {
        return notebook;
    }
}
