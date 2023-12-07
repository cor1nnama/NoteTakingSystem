package view;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import view.SignupView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import static org.junit.Assert.assertNotNull;
// Still trying to figure out how to test the Views
public class SignupViewTest {
    static String message = "";
    static boolean popUpDiscovered = false;

    /**
     * ensures there are at least 2 users in the CSV file for testing purposes
     */
    public void addTwoUsers() throws IOException {
        UserFactory uf = new CommonUserFactory();
        FileUserDataAccessObject fudao;
        try {
            fudao = new FileUserDataAccessObject("./users.csv", uf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fudao.save(uf.createUser("user1", "password1"));
        fudao.save(uf.createUser("user2", "password2"));
    }


    public JButton getSignupButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        SignupView sv = (SignupView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(0); // this should be the signup button
    }

    public JButton getCancelButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        SignupView sv = (SignupView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(1); // this should be the cancel button
    }

    /**
     *
     * Test that the CSignUp button is present and where it is expected to be
     */
    @org.junit.Test
    public void testSignupButtonPresent() {
        Main.main(null);
        JButton button = getSignupButton();
        assert(button.getText().equals("Sign Up"));
    }
    @org.junit.Test
    public void testCancelButtonPresent() {
        Main.main(null);
        JButton button = getCancelButton();
        assert(button.getText().equals("Cancel"));
    }

}
