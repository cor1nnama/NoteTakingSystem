package entity;

import java.util.ArrayList;
import java.util.Map;

public class SharedNote extends Note{
    public Map<User, Notebook> userNotebookMap;

    public SharedNote(Notebook notebook, String creationTime, String title, CommonUser owner, ArrayList<User> users){
        super(notebook, creationTime, title, owner);
    }
}
