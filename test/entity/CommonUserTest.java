package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {
    @org.junit.jupiter.api.Test
    void testSetUsername() {
        CommonUser user = new CommonUser("bgh23", "ssd");
        user.setUsername("csc207master23");
        assertEquals("csc207master23", user.username);
    }

    @org.junit.jupiter.api.Test
    void testSetPassword() {
        CommonUser user = new CommonUser("bgh23", "ssd");
        user.setPassword("password");
        assertEquals( "password", user.password);
    }

    @org.junit.jupiter.api.Test
    void testGetUsername(){
        CommonUser user = new CommonUser("csc207master", "ssd");
        assertEquals( "csc207master", user.getUsername());
    }
    @org.junit.jupiter.api.Test
    void testGetPassword(){
        CommonUser user = new CommonUser("bgh23", "ssd");
        assertEquals("ssd", user.getPassword());
    }
    @org.junit.jupiter.api.Test
    void testAddOneNotebook() {
        Notebook notebook = new Notebook("CSC207");
        CommonUser user = new CommonUser("bgh23", "ssd");
        LocalDateTime ldt = notebook.getCreationTime();
        user.addNotebook(notebook);
        assertTrue(user.notebooks.containsKey(ldt));
        Map<LocalDateTime, String> nbs = new HashMap<>();
        nbs.put(ldt, "CSC207");
        assertEquals(nbs, user.notebooks);
    }
    @org.junit.jupiter.api.Test
    void testAddMultipleNotebooks() {
        Notebook notebook1 = new Notebook ("CSC207");
        Notebook notebook2 = new Notebook ("MAT237");
        Notebook notebook3 = new Notebook ("STA257");
        CommonUser user = new CommonUser("bgh23", "ssd");
        LocalDateTime ldt1 = notebook1.getCreationTime();
        LocalDateTime ldt2 = notebook2.getCreationTime();
        LocalDateTime ldt3 = notebook3.getCreationTime();
        user.addNotebook(notebook1);
        user.addNotebook(notebook2);
        user.addNotebook(notebook3);
        Map<LocalDateTime, String> nbs = new HashMap<>();
        nbs.put(ldt1, "CSC207");
        nbs.put(ldt2, "MAT237");
        nbs.put(ldt3, "STA257");
        assertEquals(nbs, user.notebooks);
    }
}