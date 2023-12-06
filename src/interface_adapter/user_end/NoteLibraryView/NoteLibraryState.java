package interface_adapter.user_end.NoteLibraryView;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Map;

public class NoteLibraryState {
    private String username = "";
    private String buttonPressed;

    private Map<LocalDateTime, String> userNotes;



    public NoteLibraryState(NoteLibraryState copy) {
        username = copy.username;
        userNotes = copy.userNotes;
        buttonPressed = copy.buttonPressed;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NoteLibraryState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getButtonPressed() { return buttonPressed; }
    public LocalDateTime getNCreationTime(String title) {
        return userNotes.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(title))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Map<LocalDateTime, String> getNotes() {
        return userNotes;
    }
    public void setNotes(Map<LocalDateTime, String> userNotebooks) {
        this.userNotes = userNotebooks;
    }

    public void setNoteError(String error) {
        JOptionPane.showMessageDialog(null, "Error opening note.");
    }
}

