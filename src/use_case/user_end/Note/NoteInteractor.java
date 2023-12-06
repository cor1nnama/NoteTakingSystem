package use_case.user_end.Note;

import data_access.NoteDataAccessInterface;
import data_access.NotebookDataAccessInterface;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Map;

public class NoteInteractor implements NoteInputBoundary {
    final NoteDataAccessInterface noteDAO;
    final NoteUserDataAccessInterface noteUserDAO;
    final NoteOutputBoundary notePresenter;
    final String TRASH = "Trash";
    final String OPEN = "Open";
    final String EDIT = "Edit";
    final String DELETE = "Delete";

    public NoteInteractor(NoteDataAccessInterface noteDAO, NoteUserDataAccessInterface noteUserDAO, NoteOutputBoundary noteOutputBoundary) {
        this.noteDAO = noteDAO;
        this.noteUserDAO = noteUserDAO;
        this.notePresenter = noteOutputBoundary;
    }
    @Override
    public void execute(NoteInputData noteInputData) {
        String action = noteInputData.getAction();
        if (action.equals(OPEN)) {

            //notePresenter.prepareSuccessView(noteOutputData);
        } else if (action.equals(TRASH)) {

        }  else if (action.equals(DELETE)) {

            JOptionPane.showMessageDialog(null, "Notebook Deleted");
        }

    }
}

