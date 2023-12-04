package entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NoteFactoryTest {

    @Test
    void createTest() {
        NoteFactory noteFactory = new NoteFactory();
        ArrayList <String> tags = new ArrayList<>();
        tags.add("SOLID");
        tags.add("API");
        assertEquals("Week 4",noteFactory.create("Week 4", tags, null).getTitle());
        assertEquals(tags,noteFactory.create("Week 4", tags, null).getTags());
    }
}