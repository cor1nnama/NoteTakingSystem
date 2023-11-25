package data_access;


import entity.Note;

import java.util.ArrayList;

public interface EditNoteDataAccessInterface {
    public String open(Note note);
    Note getNoteByCreationTime(String title);
    ArrayList<Note> getAllNotes();

    void saveEdit(Note note);

}
