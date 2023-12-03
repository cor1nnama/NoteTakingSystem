package use_case.notes.add_tags;

import data_access.InMemoryDataAccessObject;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import entity.Note;
import org.junit.jupiter.api.Test;

class AddTagInteractorTest {

    @Test
    void successTest() {
        AddTagDataAccessInterface noteRepo = new InMemoryDataAccessObject();
        Note note = noteRepo.getAllNotes().get(0);
        LocalDateTime ldt = note.creationTime;


        AddTagInputData inputData = new AddTagInputData("Software", ldt);

        AddTagOutputBoundary successPresenter = new AddTagOutputBoundary() {
            @Override
            public void prepareSuccessView(AddTagOutputData addTagOutputData) {
                assertTrue(note.tags.contains("Software"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        AddTagInputBoundary interactor = new AddTagInteractor(noteRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureTagAlreadyExists() {
        AddTagDataAccessInterface noteRepo = new InMemoryDataAccessObject();
        Note note = noteRepo.getAllNotes().get(0);
        LocalDateTime ldt = note.creationTime;
        AddTagInputData inputData = new AddTagInputData("OOP", ldt);

        AddTagOutputBoundary failurePresenter = new AddTagOutputBoundary() {
            @Override
            public void prepareSuccessView(AddTagOutputData addTagOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Tag Already Exists", error);
            }
        };

        AddTagInputBoundary interactor = new AddTagInteractor(noteRepo, failurePresenter);
        interactor.execute(inputData);
    }
}