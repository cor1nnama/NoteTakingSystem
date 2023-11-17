package entity;

import java.util.ArrayList;

public class NoteFactory {
    public Note create(String title, ArrayList<String> tags, String date, String author) { return new Note(title, tags, date, author); }
}
