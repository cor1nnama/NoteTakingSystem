package use_case.notes.create_note;

import entity.Note;

import java.io.IOException;

public interface CreateNoteDataAccessInterface {

    void save(Note note);
    void writeToFile() throws IOException;
    void readFromFile() throws IOException;
    void saveNote(Note note) throws IOException;



    boolean existsByTitle(String title);
}
