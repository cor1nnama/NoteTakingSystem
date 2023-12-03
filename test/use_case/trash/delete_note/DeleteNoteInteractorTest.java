package use_case.trash.delete_note;

import data_access.EditNoteDataAccessInterface;
import data_access.InMemoryDataAccessObject;
import entity.Note;
import use_case.notes.edit_notes.*;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNoteInteractorTest {
    @org.junit.jupiter.api.Test
    void successTest() throws IOException {
        DeleteNoteDataAccessInterface noteRepo = new InMemoryDataAccessObject();
        Note note = noteRepo.getAllNotes().get(0);
        LocalDateTime creationTime = note.creationTime;
        DeleteNoteInputData inputData = new DeleteNoteInputData(creationTime);
        DeleteNoteOutputBoundary successPresenter = new DeleteNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteNoteOutputData deleteNoteOutputData) {
                assertFalse(noteRepo.getAllNotes().contains(note));

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }
        };
        DeleteNoteInputBoundary interactor = new DeleteNoteInteractor(noteRepo, successPresenter);
        interactor.execute(inputData);
    }

}