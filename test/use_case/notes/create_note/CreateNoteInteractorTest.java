package use_case.notes.create_note;

import data_access.InMemoryDataAccessObject;
import entity.NoteFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
// This is just a basic skeleton. Once the rest of the CreateNote classes are created I will update this file
class CreateNoteInteractorTest {
    @Test
    void successTest() {
        CreateNoteInputData inputData = new CreateNoteInputData("Week 9", "Regex", "Imtiaz");
        CreateNoteDataAccessInterface noteRepo = new InMemoryDataAccessObject();

        CreateNoteOutputBoundary successPresenter = new CreateNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(NoteLibraryOutputData NLod) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertTrue(noteRepo.existsByTitle("Week 9"));
                assertTrue(NLod.getTags().contains("Regex"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        NoteLibraryInputBoundary interactor = new CreateNoteInteractor(noteRepo, successPresenter, new NoteFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureNoteExistsTest() {
        CreateNoteInputData inputData = new CreateNoteInputData("CSC207", "Regex", "Imtiaz");
        CreateNoteDataAccessInterface noteRepo = new InMemoryDataAccessObject();

        CreateNoteOutputBoundary successPresenter = new CreateNoteOutputBoundary()  {
            @Override
            public void prepareSuccessView(NoteOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Title already exists.", error);
            }
        };

        NoteLibraryInputBoundary interactor = new SignupInteractor(noteRepo, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }


}