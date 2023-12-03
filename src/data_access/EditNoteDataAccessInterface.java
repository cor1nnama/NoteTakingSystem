package data_access;


import entity.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface EditNoteDataAccessInterface {
    Note getNoteByCreationTime(LocalDateTime creationTime);
    ArrayList<Note> getAllNotes();

    void saveEdit(Note note);

}
