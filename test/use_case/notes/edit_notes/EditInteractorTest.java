package use_case.notes.edit_notes;

import data_access.EditNoteDataAccessInterface;
import data_access.InMemoryDataAccessObject;
import entity.Note;
import entity.NoteFactory;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class EditInteractorTest {

    @org.junit.jupiter.api.Test
    void successTest() throws IOException {
        EditNoteDataAccessInterface noteRepo = new InMemoryDataAccessObject();
        Note note = noteRepo.getAllNotes().get(0);
        LocalDateTime creationTime = note.creationTime;
        EditInputData editInputData = new EditInputData(creationTime, "CSC207 Lecture Week 6", "Testing is important");
        EditNoteOutputBoundary successPresenter = new EditNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(EditOutputData editOutputData) {
                assertEquals("CSC207 Lecture Week 6", noteRepo.getNoteByCreationTime(creationTime).getTitle());
                assertEquals("Testing is important", noteRepo.getNoteByCreationTime(creationTime).getContent());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }
        };
        EditNoteInputBoundary interactor = new EditInteractor(noteRepo, successPresenter);
        interactor.execute(editInputData);
    }
}