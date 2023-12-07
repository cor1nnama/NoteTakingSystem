package use_case.notes.create_notebook;

import java.io.IOException;

public interface CreateNotebookInputBoundary {
    void execute(CreateNotebookInputData createNotebookInputData) throws IOException;
}
