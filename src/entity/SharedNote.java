package entity;

import java.util.ArrayList;

public class SharedNote extends Note{
    public ArrayList<User> sharedUsers;

    public SharedNote(Notebook notebook, String creationTime, String title, CommonUser owner, ArrayList<User> users){
        super(notebook, creationTime, title, owner);
        this.sharedUsers = new ArrayList<User>();
        sharedUsers.add(owner);
        sharedUsers.addAll(users);
    }
}
