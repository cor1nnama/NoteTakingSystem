package use_case.notes.create_notebook;

import entity.User;

public class CreateNotebookInputData {
    public String notebookName;
    public User owner;
    public CreateNotebookInputData(String notebookName, User owner){
        this.notebookName = notebookName;
        this.owner = owner;
    }

    String getNotebookName() {
        return notebookName;
    }
}
