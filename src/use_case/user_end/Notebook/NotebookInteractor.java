package use_case.user_end.Notebook;

public class NotebookInteractor implements NotebookInputBoundary {
    final NotebookUserDataAccessInterface notebookUserDAO;
    final NotebookOutputBoundary notebookPresenter;

    public NotebookInteractor(NotebookUserDataAccessInterface notebookUserDAO, NotebookOutputBoundary notebookOutputBoundary) {
        this.notebookUserDAO = notebookUserDAO;
        this.notebookPresenter = notebookOutputBoundary;
    }
    @Override
    public void execute(NotebookInputData notebookInputData) {

    }
}
