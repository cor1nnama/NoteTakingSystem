package use_case.notes.create_notebook;

public interface CreateNotebookOutputBoundary {

    void prepareFailView(String s);

    void prepareSuccessView(CreateNotebookOutputData createNotebookOutputData);
}
