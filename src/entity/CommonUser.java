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
    public void changeUsername(String newName) {
        this.username = newName;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
