package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Notebook {
    // categorize notes into different topic etc.
    public String name;
    private final LocalDateTime creationTime;
    public ArrayList<Note> notes;

    public Notebook(String name){
        this.name = name;
        this.creationTime = LocalDateTime.now();
        this.notes = new ArrayList<Note>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) { notes.add(note); }

    public String getCreationTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return creationTime.format(format);
    }
}
