package use_case.trash.delete_note;

import java.io.IOException;

public interface DeleteNoteInputBoundary {
    public void execute(DeleteNoteInputData deleteNoteInputData) throws IOException;
}
