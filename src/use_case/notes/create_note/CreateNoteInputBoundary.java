package use_case.notes.create_note;

import java.io.IOException;

public interface CreateNoteInputBoundary {
    void execute(CreateNoteInputData createNoteInputData) throws IOException;
 }
