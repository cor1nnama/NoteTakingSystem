package use_case.notes.add_tags;


import java.io.IOException;

public interface AddTagInputBoundary {
    void execute(AddTagInputData addTagNoteInputData) throws IOException;
}
