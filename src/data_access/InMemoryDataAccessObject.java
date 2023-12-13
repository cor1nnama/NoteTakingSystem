package data_access;

import entity.Note;
import use_case.notes.add_tags.AddTagDataAccessInterface;
import use_case.notes.create_note.CreateNoteDataAccessInterface;
import use_case.trash.delete_note.DeleteNoteDataAccessInterface;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDataAccessObject implements EditNoteDataAccessInterface, AddTagDataAccessInterface, CreateNoteDataAccessInterface, DeleteNoteDataAccessInterface {
    private final Map<LocalDateTime, Note> map = new HashMap<>();

    public InMemoryDataAccessObject() {
        ArrayList <String> tags = new ArrayList<>();
        Note note1 = new Note("CSC207", tags);
        note1.setTag("OOP");
        LocalDateTime ldt = note1.creationTime;
        map.put(ldt, note1);

    }

    @Override
    public void addTag(String tag, LocalDateTime ldt) {
        Note note = getNoteByCreationTime(ldt);
        note.setTag(tag);
    }

    @Override
    public void delete(Note note) throws IOException {
        map.remove(note.creationTime);
    }

    @Override
    public Note getNoteByCreationTime(LocalDateTime creationTime) {
        return map.get(creationTime);
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        Collection<Note> values= map.values();
        return new ArrayList<>(values);
    }

    @Override
    public void saveEdit(Note note) {
        map.put(note.creationTime, note);

    }

    @Override
    public void save(Note note) {
        map.put(note.creationTime, note);

    }

    @Override
    public void writeToFile() throws IOException {

    }

    @Override
    public void readFromFile() throws IOException {

    }

    //delete?
    public void saveNote(Note note) throws IOException {
        map.put(note.creationTime, note);

    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }
}
