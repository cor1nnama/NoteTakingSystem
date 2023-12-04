package interface_adapter.user_end.NotebookLibraryView;

import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInputData;

public class NotebookLibraryController {

    final NotebookInputBoundary notebookUseCaseInteractor;

    public NotebookLibraryController(NotebookInputBoundary notebookUseCaseInteractor) {
        this.notebookUseCaseInteractor = notebookUseCaseInteractor;
    }

    public void execute(String buttonPressed) {
        NotebookInputData notebookInputData = new NotebookInputData(buttonPressed);

        notebookUseCaseInteractor.execute(notebookInputData);
    }

}
