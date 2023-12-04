package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class Notebook {
    // categorize notes into different topic etc.
    public String name;
    private final LocalDateTime creationTime;
    public Map<LocalDateTime, String> notes;

    public Notebook(String name){
        this.name = name;
        this.creationTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<LocalDateTime, String> getNotes() {
        return notes;
    }

    public void addNote(Note note) { notes.put(note.creationTime, note.title); }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
