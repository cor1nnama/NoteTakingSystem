package view;

import data_access.EditNoteDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditController;
import interface_adapter.notes.editNote.EditPresenter;
import interface_adapter.notes.editNote.EditViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.notes.edit_notes.EditInteractor;
import use_case.notes.edit_notes.EditNoteInputBoundary;
import use_case.notes.edit_notes.EditNoteOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class EditUseCaseFactory {
    public static EditView create(
            ViewManagerModel viewManagerModel, EditViewModel editViewModel, EditNoteDataAccessInterface userDataAccessObject, NotebookLibraryViewModel notebookLibraryViewModel) {

        try {
            EditController editController = createUserEditCase(viewManagerModel, editViewModel, userDataAccessObject, notebookLibraryViewModel);
            return new EditView(editViewModel, editController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data fil.");
        }

        return null;
    }
    private static EditController createUserEditCase(ViewManagerModel viewManagerModel, EditViewModel editViewModel, EditNoteDataAccessInterface userDataAccessObject, NotebookLibraryViewModel notebookLibraryViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        EditNoteOutputBoundary editOutputBoundary = new EditPresenter(viewManagerModel, editViewModel, notebookLibraryViewModel);
        EditNoteInputBoundary editInteractor = new EditInteractor(
                userDataAccessObject, editOutputBoundary);

        return new EditController(editInteractor);
    }
}
