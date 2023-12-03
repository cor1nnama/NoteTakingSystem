package use_case.notes.edit_notes;

import data_access.EditNoteDataAccessInterface;
import entity.Note;

import java.time.LocalDateTime;
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
        LocalDateTime creationTime = editInputData.getCreationTime();
        String title = editInputData.getTitle();
        String content = editInputData.getContent();
        Note currNote = editNoteDataAccessInterface.getNoteByCreationTime(creationTime);
        ArrayList<Note> allNotes = editNoteDataAccessInterface.getAllNotes();
        EditOutputData editOutputData = null;
        currNote.setTitle(title);
        currNote.setContent(content);
        editNoteDataAccessInterface.saveEdit(currNote);
        editPresenter.prepareSuccessView(editOutputData);
    }
}
