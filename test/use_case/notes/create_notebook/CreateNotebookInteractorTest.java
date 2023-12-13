package use_case.notes.create_notebook;

import data_access.InMemoryNotebookDataAccessObject;
import data_access.NotebookDataAccessInterface;
import entity.CommonUser;
import entity.NotebookFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreateNotebookInteractorTest {
    @Test
    void successTest() throws IOException {
        CommonUser user = new CommonUser ("username", "password");
        CreateNotebookInputData inputData = new CreateNotebookInputData("CSC207", "username");
        NotebookDataAccessInterface notebookRepo = new InMemoryNotebookDataAccessObject();

        CreateNotebookOutputBoundary successPresenter = new CreateNotebookOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateNotebookOutputData nb) {
                assertEquals("CSC207", nb.getNotebookName());
                assertTrue(notebookRepo.existsByName("username"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        CreateNotebookInputBoundary interactor = new CreateNotebookInteractor(notebookRepo, successPresenter, new NotebookFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureNotebookExistsTest() throws IOException {
        CommonUser user = new CommonUser ("username", "password");
        CreateNotebookInputData inputData = new CreateNotebookInputData("CSC207", "username");
        NotebookDataAccessInterface notebookRepo = new InMemoryNotebookDataAccessObject();

        CreateNotebookOutputBoundary successPresenter = new CreateNotebookOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateNotebookOutputData nb) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Notebook already exists.", error);
            }
        };

        CreateNotebookInputBoundary interactor = new CreateNotebookInteractor(notebookRepo, successPresenter, new NotebookFactory());
        interactor.execute(inputData);
    }

}