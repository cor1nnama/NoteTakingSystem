package entity;

import java.util.ArrayList;

public class Notebook {
    // categorize notes into different topic etc.
    public String name;
    public String owner;
    public ArrayList<Note> notes;

    public Notebook(String name, String owner){
        this.name = name;
        this.owner = owner;
        this.notes = new ArrayList<Note>();
    }

    public String getOwner() {
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
}
