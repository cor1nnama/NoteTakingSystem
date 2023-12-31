package view;

import app.Main;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    public JButton getLoginButtonLogin() {
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

        LoginView sv = (LoginView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(5);

        return (JButton) buttons.getComponent(0); // this should be the login button
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

        LoginView sv = (LoginView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(5);

        return (JButton) buttons.getComponent(1); // this should be the cancel button
    }
    @Test
    public void testLoginButtonPresentLogin() {
        Main.main(null);
        JButton button = getLoginButtonLogin();
        assert(button.getText().equals("Login"));
    }
    @org.junit.Test
    public void testCancelButtonPresent() {
        Main.main(null);
        JButton button = getCancelButton();
        assert(button.getText().equals("Cancel"));
    }

}