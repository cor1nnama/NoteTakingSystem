package interface_adapter.notes.create_notebook;

import entity.User;
import use_case.notes.create_notebook.CreateNotebookInputBoundary;
import use_case.notes.create_notebook.CreateNotebookInputData;

import java.io.IOException;

public class CreateNotebookController {
    final CreateNotebookInputBoundary createNotebookInteractor;
    public CreateNotebookController(CreateNotebookInputBoundary createNotebookInteractor){
        this.createNotebookInteractor = createNotebookInteractor;
    }

    public void execute(String notebookName, String username) throws IOException {
        CreateNotebookInputData createNotebookInputData = new CreateNotebookInputData(notebookName, username);
        createNotebookInteractor.execute(createNotebookInputData);
    }
}
