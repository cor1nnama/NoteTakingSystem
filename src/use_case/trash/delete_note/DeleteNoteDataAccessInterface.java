package use_case.trash.delete_note;

import entity.Note;

import java.time.LocalDateTime;

public interface DeleteNoteDataAccessInterface {
    void delete (Note note);
    Note getNoteByCreationTime (LocalDateTime creationTime);
}
