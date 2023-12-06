package use_case.user_end.Notebook;

import data_access.NotebookDataAccessInterface;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class NotebookInteractor implements NotebookInputBoundary {
    final NotebookDataAccessInterface notebookDAO;
    final NotebookUserDataAccessInterface notebookUserDAO;
    final NotebookOutputBoundary notebookPresenter;
    final String TRASH = "Trash";
    final String OPEN = "Open";
    final String EDIT = "Edit";
    final String DELETE = "Delete";

    public NotebookInteractor(NotebookDataAccessInterface notebookDAO, NotebookUserDataAccessInterface notebookUserDAO, NotebookOutputBoundary notebookOutputBoundary) {
        this.notebookDAO = notebookDAO;
        this.notebookUserDAO = notebookUserDAO;
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
            String userInput = JOptionPane.showInputDialog("Enter new title:");
            if (userInput != null) {
                notebookDAO.renameNotebook(notebookInputData.getselectedNotebook(), userInput);
                notebookPresenter.reloadView();

            }
        } else if (action.equals(DELETE)) {
            notebookUserDAO.get(notebookInputData.getCurrUser()).removeNotebook(notebookInputData.getselectedNotebook());
            notebookDAO.deleteNotebook(notebookInputData.getselectedNotebook());
            notebookPresenter.reloadView();
            JOptionPane.showMessageDialog(null, "Notebook Deleted");
        }

    }
}

