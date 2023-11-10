package interface_adapter.notes.create_notebook;

public class CreateNotebookState {
    private String notebookName = "";
    private String notebookNameError = null;
    public CreateNotebookState(CreateNotebookState copy){
        notebookName = copy.notebookName;
        notebookNameError = copy.notebookNameError;
    }

    public CreateNotebookState() {}

    public String getNotebookName(){return notebookName;}

    public String getNotebookNameError(){return notebookNameError;}

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public void setNotebookNameError(String notebookNameError) {
        this.notebookNameError = notebookNameError;
    }
}
