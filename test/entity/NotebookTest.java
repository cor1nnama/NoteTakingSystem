package entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {
    @org.junit.jupiter.api.Test
    void testGetName() {
        Notebook notebook = new Notebook("CSC207");
        assertEquals("CSC207", notebook.getName());
    }
    @org.junit.jupiter.api.Test
    void testSetName() {
        Notebook notebook = new Notebook(null);
        notebook.setName("CSC236");
        assertEquals("CSC236", notebook.name);

    }
    @org.junit.jupiter.api.Test
    void testGetNotes() {
        Notebook notebook = new Notebook("CSC207");
        Map <LocalDateTime, String> notes = new HashMap<>();
        ArrayList <String> tags = new ArrayList<>();
        tags.add("software");
        tags.add("OOP");
        Note note1 = new Note("Week1", tags );
        Note note2 = new Note("Week2", tags );
        Note note3 = new Note("Week3", tags);
        notes.put(note1.creationTime, note1.title);
        notes.put(note2.creationTime, note2.title);
        notes.put(note3.creationTime, note3.title);
        assertEquals(notes, notebook.getNotes());
    }
    @org.junit.jupiter.api.Test
   void testAddNote() {
       Notebook notebook = new Notebook("CSC207");
       ArrayList <String> tags = new ArrayList<>();
       tags.add("software");
       tags.add("OOP");
       Note note1 = new Note("Week1", tags );
       Note note2 = new Note("Week2", tags );
       notebook.addNote(note1);
       notebook.addNote(note2);
       assertTrue(notebook.notes.containsKey(note1.creationTime));
       assertTrue(notebook.notes.containsKey(note2.creationTime));
   }


}