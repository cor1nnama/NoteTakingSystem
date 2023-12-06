package use_case.user_end.Notebook;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class NotebookInteractor implements NotebookInputBoundary {
    final NotebookUserDataAccessInterface notebookDAO;
    final NotebookOutputBoundary notebookPresenter;
    final String TRASH = "Trash";
    final String OPEN = "Open";
    final String EDIT = "Edit";
    final String DELETE = "Delete";

    public NotebookInteractor(NotebookUserDataAccessInterface notebookUserDAO, NotebookOutputBoundary notebookOutputBoundary) {
        this.notebookDAO = notebookUserDAO;
        this.notebookPresenter = notebookOutputBoundary;
    }
    @Override
    public void execute(NotebookInputData notebookInputData) {
        String action = notebookInputData.getAction();
        if (action.equals(OPEN)) {
            Map<LocalDateTime, String> notes = notebookDAO.getNotesInNotebook(notebookInputData.getselectedNotebook());
            NotebookOutputData notebookOutputData = new NotebookOutputData(notes);
            notebookPresenter.prepareSuccessView(notebookOutputData);
        } else if (action.equals(TRASH)) {

        } else if (action.equals(EDIT)) {

        } else if (action.equals(DELETE)) {

        }

        }
    }
}
