package data_access;

import entity.Note;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface {
    @Override
    public void create(Note note) {
        //saves note in memory
    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }
}
