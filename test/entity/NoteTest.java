package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {
    @org.junit.jupiter.api.Test
    void testSetTag() {
        ArrayList<String> tags = new ArrayList<>();
        String tag1 = "software";
        String tag2 = "OOP";
        Note note = new Note("Week1", null);
        note.setTag(tag1);
        note.setTag(tag2);
        assertTrue(note.tags.contains(tag1));
        assertTrue(note.tags.contains(tag2));
    }

    @org.junit.jupiter.api.Test
    void testToString(){
        String tag1 = "software";
        String tag2 = "OOP";
        ArrayList<String> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        Note note = new Note("Week 1", tags);
        note.setContent("This course is about software design");
        String ldt = note.getCreationTime();
        assertEquals("Note{" +
                "title=" + "Week 1" +
                ", tags=" + tags +
                ", creationTime=" + ldt +
                ", content=" + "This course is about software design" +
                "}", note.toString());

    }

}