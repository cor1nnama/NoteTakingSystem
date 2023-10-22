package entity;

import java.util.ArrayList;

public class Trash {
    // this class temporarily stores deleted notes
    public ArrayList<Note> deleted;
    public Trash(){
        this.deleted = new ArrayList<Note>();
    }
}
