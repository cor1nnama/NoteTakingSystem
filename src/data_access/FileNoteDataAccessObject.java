package data_access;

import entity.Note;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

import java.util.ArrayList;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface {
    @Override
    public void create(Note note) {
        //saves note in memory
    }

    @Override
    public void save(Note note) {

    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }

    @Override
    public String open(Note note) {
        return null;
    }

    @Override
    public Note getNotebyTitle(String title) {
        return null;
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        return null;
    }

    @Override
    public void saveEdit(Note note) {

    }
}
