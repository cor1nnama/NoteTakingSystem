package use_case.notes.add_tags;

import entity.Note;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface AddTagDataAccessInterface {
    void addTag (String tag, LocalDateTime ldt) throws IOException;
    Note getNoteByCreationTime(LocalDateTime creationTime);
    ArrayList <Note> getAllNotes();
}
