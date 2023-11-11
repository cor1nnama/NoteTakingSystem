package use_case.notes.edit_notes;

import data_access.EditNoteDataAccessInterface;

public class EditInteractor implements EditNoteInputBoundary {
    final EditNoteDataAccessInterface editNoteDataAccessInterface;
    final EditNoteOutputBoundary editPresenter;
    public EditInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                           EditNoteOutputBoundary editPresenter) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.editPresenter = editPresenter;
    }

    @Override
    public void execute(EditInputData editInputData) {

    }
}
