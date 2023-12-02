package use_case.user_end.Notebook;
public interface NotebookOutputBoundary {
    void prepareSuccessView(NotebookOutputData notes);
    void prepareFailView(String error);
}
