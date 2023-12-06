package use_case.notes.create_note;

import entity.Note;

import java.io.IOException;

public interface CreateNoteDataAccessInterface {

    void save(Note note) throws IOException;
    void writeToFile() throws IOException;
    void readFromFile() throws IOException;




    boolean existsByTitle(String title);
}
