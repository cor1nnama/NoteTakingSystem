package data_access;

import entity.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDataAccessObject implements EditNoteDataAccessInterface {
    private final Map<LocalDateTime, Note> map = new HashMap<>();

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

    }
}
