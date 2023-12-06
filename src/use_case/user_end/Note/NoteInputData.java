package use_case.user_end.Note;

import java.time.LocalDateTime;

public class NoteInputData {
    private final LocalDateTime selectedNotebook;
    private final String action;
    private final String currUser;


    public NoteInputData(LocalDateTime buttonPressed, String action, LocalDateTime currUser) {
        this.selectedNotebook = buttonPressed;
        this.action = action;
        this.currUser = currUser;
    }

    LocalDateTime getselectedNotebook() { return selectedNotebook; }
    String getAction() { return action; }
    public String getCurrUser() { return currUser; }
}
