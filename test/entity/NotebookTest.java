package entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

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
        ArrayList<Note> notes = new ArrayList<>();
        ArrayList <String> tags = new ArrayList<>();
        tags.add("software");
        tags.add("OOP");
        Note note1 = new Note("Week1", tags );
        Note note2 = new Note("Week2", tags );
        Note note3 = new Note("Week3", tags);
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notebook.notes = notes;
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
       assertTrue(notebook.notes.contains(note1));
       assertTrue(notebook.notes.contains(note2));
   }


}