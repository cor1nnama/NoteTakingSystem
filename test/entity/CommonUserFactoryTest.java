package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserFactoryTest {

    @Test
    void createUserTest() {
        CommonUserFactory userFactory = new CommonUserFactory();
        assertEquals("Imtiaz", userFactory.createUser("Imtiaz", "snap23!").getUsername());
        assertEquals("snap23!", userFactory.createUser("Imtiaz", "snap23!").getPassword());
    }
}