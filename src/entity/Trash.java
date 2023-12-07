package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Trash implements Serializable {
    // this class temporarily stores deleted notes
    public ArrayList<Note> deleted;
    public Trash(){
        this.deleted = new ArrayList<Note>();
    }


}
