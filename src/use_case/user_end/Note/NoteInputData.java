package use_case.user_end.Note;

import java.time.LocalDateTime;

public class NoteInputData {
    private final LocalDateTime selectedNote;
    private final String action;
    private final LocalDateTime currNotebook;


    public NoteInputData(LocalDateTime buttonPressed, String action, LocalDateTime currNotebook) {
        this.selectedNote = buttonPressed;
        this.action = action;
        this.currNotebook = currNotebook;
    }

    LocalDateTime getselectedNote() { return selectedNote; }
    String getAction() { return action; }
    public LocalDateTime getCurrNotebook() { return currNotebook; }
}
