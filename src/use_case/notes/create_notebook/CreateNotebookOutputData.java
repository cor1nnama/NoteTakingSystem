package use_case.notes.create_notebook;

public class CreateNotebookOutputData {
    String notebookName;
    boolean useCaseFailed;
    CreateNotebookOutputData(String notebookName, boolean tf){
        this.notebookName = notebookName;
        this.useCaseFailed = tf;
    }

    public String getNotebookName() {
        return notebookName;
    }
}
