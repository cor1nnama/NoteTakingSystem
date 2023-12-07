package interface_adapter.user_end.NoteLibraryView;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Map;

public class NoteLibraryState {
    private LocalDateTime notebook;
    private String buttonPressed;

    private Map<LocalDateTime, String> userNotes;



    public NoteLibraryState(NoteLibraryState copy) {
        notebook = copy.notebook;
        userNotes = copy.userNotes;
        buttonPressed = copy.buttonPressed;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NoteLibraryState() {}

    public LocalDateTime getNotebook() {
        return notebook;
    }
    public void setNotebook(LocalDateTime notebook) { this.notebook = notebook; }
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

