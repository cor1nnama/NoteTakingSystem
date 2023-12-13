package view;

import app.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class EditViewTest {
    public JButton getSaveButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        Assertions.assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        EditView sv = (EditView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(5);

        return (JButton) buttons.getComponent(0);
    }


    @Test
    public void testSaveButtonPresent() {
        Main.main(null);
        JButton button = getSaveButton();
        assert(button.getText().equals("Save"));
    }

}