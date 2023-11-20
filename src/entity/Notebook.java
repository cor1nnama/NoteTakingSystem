package entity;

import java.util.ArrayList;

public class Notebook {
    // categorize notes into different topic etc.
    public String name;
    public User owner;
    public ArrayList<Note> notes;

    public Notebook(String name, CommonUser owner){
        this.name = name;
        this.owner = owner;
        this.notes = new ArrayList<Note>();
    }

    public User getOwner() {
        return owner;
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
}
