package entity;

import java.util.ArrayList;

public class Notebook {
    // categorize notes into different topic etc.
    public String name;
    private ArrayList<Note> notes;

    public Notebook(String name){
        this.name = name;
        this.notes = new ArrayList<Note>();
    }

    public void addNote(){

    }

    public void moveNote(){

    }
}
