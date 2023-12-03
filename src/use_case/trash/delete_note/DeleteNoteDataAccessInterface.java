package use_case.trash.delete_note;

import entity.Note;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface DeleteNoteDataAccessInterface {
    void delete (Note note) throws IOException;
    Note getNoteByCreationTime (LocalDateTime creationTime);

    ArrayList<Note> getAllNotes();
}
