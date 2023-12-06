package use_case.user_end.Notebook;

import java.time.LocalDateTime;

public class NotebookInputData {
    private final LocalDateTime selectedNotebook;
    private final String action;

    public NotebookInputData(LocalDateTime buttonPressed, String action) {
        this.selectedNotebook = buttonPressed;
        this.action = action;
    }

    LocalDateTime getselectedNotebook() { return selectedNotebook; }
    String getAction() { return action; }
}
