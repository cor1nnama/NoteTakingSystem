package use_case.user_end.Notebook;

import java.time.LocalDateTime;

public class NotebookInputData {
    private final LocalDateTime selectedNotebook;
    private final String action;
    private final String currUser;


    public NotebookInputData(LocalDateTime buttonPressed, String action, String currUser) {
        this.selectedNotebook = buttonPressed;
        this.action = action;
        this.currUser = currUser;
    }

    LocalDateTime getselectedNotebook() { return selectedNotebook; }
    String getAction() { return action; }
    public String getCurrUser() { return currUser; }
}
