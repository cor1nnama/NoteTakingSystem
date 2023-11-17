package data_access;

import entity.Note;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface {
    @Override
    public String open(Note note) {
        return note.getContent();
    }

    @Override
    public void save() {

    }
}
