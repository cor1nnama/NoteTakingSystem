package use_case.user_end.Notebook;

import use_case.user_end.login.LoginInteractor;

public class NotebookInteractor implements NotebookInputBoundary {
    final NotebookUserDataAccessInterface notebookUserDAO;
    final NotebookOutputBoundary notebookPresenter;

    public NotebookInteractor(NotebookUserDataAccessInterface notebookUserDAO)
    @Override
    public void execute(NotebookInputData notebookInputData) {

    }
}
