package use_case.notes.create_notebook;

import entity.User;

import java.time.LocalDateTime;

public class CreateNotebookInputData {
    private String notebookName;
    private String owner;
    public CreateNotebookInputData(String notebookName, String owner){
        this.notebookName = notebookName;
        this.owner = owner;
    }

    String getNotebookName() {
        return notebookName;
    }
    String getOwner() {return owner;}

}
