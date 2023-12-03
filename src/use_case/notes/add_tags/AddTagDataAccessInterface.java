package use_case.notes.add_tags;

import entity.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface AddTagDataAccessInterface {
    void addTag (String tag, LocalDateTime ldt);
    Note getNoteByCreationTime(LocalDateTime creationTime);
}
