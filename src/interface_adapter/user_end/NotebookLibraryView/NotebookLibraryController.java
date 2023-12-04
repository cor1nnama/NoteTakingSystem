package interface_adapter.user_end.NotebookLibraryView;

import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInputData;

import java.time.LocalDateTime;

public class NotebookLibraryController {

    final NotebookInputBoundary notebookUseCaseInteractor;

    public NotebookLibraryController(NotebookInputBoundary notebookUseCaseInteractor) {
        this.notebookUseCaseInteractor = notebookUseCaseInteractor;
    }

    public void execute(LocalDateTime selectedNotebook, String action) {
        NotebookInputData notebookInputData = new NotebookInputData(selectedNotebook, action);

        notebookUseCaseInteractor.execute(notebookInputData);
    }

}
