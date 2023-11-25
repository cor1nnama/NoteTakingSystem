package use_case.notes.edit_notes;

import data_access.EditNoteDataAccessInterface;
import entity.Note;

import java.util.ArrayList;

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
        Note newNote = editInputData.getNote();
        Note currNote = editNoteDataAccessInterface.getNoteByCreationTime(newNote.getCreationTime());
        ArrayList<Note> allNotes = editNoteDataAccessInterface.getAllNotes();
        EditOutputData editOutputData = null;
        int count = 0;
        for (Note note : allNotes) {
            if (note.getTitle().equals(newNote.getTitle())) {
                count = count + 1;
            }
        }
        if (count > 1) {
            editPresenter.prepareFailView("Title already exists in another note");
        }
        else {
            currNote.setTitle(newNote.getTitle());
            currNote.setContent(newNote.getContent());
            editNoteDataAccessInterface.saveEdit(newNote);
            editPresenter.prepareSuccessView(editOutputData);
        }

    }
}
