package use_case.notes.edit_notes;

import data_access.EditNoteDataAccessInterface;
import data_access.InMemoryDataAccessObject;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class EditInteractorTest {

    @org.junit.jupiter.api.Test
    void successTest() {
        EditNoteDataAccessInterface editNoteDataAccessInterface = new InMemoryDataAccessObject();
        LocalDateTime creationTime = LocalDateTime.of(2015,
                Month.MAY, 29, 19, 30, 40);
        EditInputData editInputData = new EditInputData(creationTime, "CSC207 Lecture Week 6", "Testing is important...");
        EditNoteOutputBoundary successPresenter = new EditNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(EditOutputData editOutputData) {
                assertEquals("CSC207 Lecture Week 6", editNoteDataAccessInterface.getNoteByCreationTime(creationTime).getTitle());
                assertEquals("Testing is important", editNoteDataAccessInterface.getNoteByCreationTime(creationTime).getContent());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }
        };
        EditNoteInputBoundary interactor = new EditInteractor(editNoteDataAccessInterface, successPresenter);
        interactor.execute(editInputData);
    }
}