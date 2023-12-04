package interface_adapter.user_end.NotebookLibraryView;

import entity.Notebook;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class NotebookLibraryState {
    private String username = "";
    private String buttonPressed;

    private Map<LocalDateTime, String> userNotebooks;



    public NotebookLibraryState(NotebookLibraryState copy) {
        username = copy.username;
        userNotebooks = copy.userNotebooks;
        buttonPressed = copy.buttonPressed;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NotebookLibraryState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getButtonPressed() { return buttonPressed; }
    public LocalDateTime getNBCreationTime(String title) {
        return userNotebooks.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(title))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Map<LocalDateTime, String> getUserNotebooks() {
        return userNotebooks;
    }
    public void setUserNotebooks(Map<LocalDateTime, String> userNotebooks) {
        this.userNotebooks = userNotebooks;
    }

    public void setNoteError(String error) {
        JOptionPane.showMessageDialog(null, "Error opening note.");
    }
}

