package entity;

import java.util.ArrayList;

public class NoteFactory {

    public void initializeNotes() {
        //reads file for stored notes and makes them as objects
    }

    public Note create(String title, ArrayList<String> tags, String date, CommonUser author) { return new Note(title, tags, author); }
}
