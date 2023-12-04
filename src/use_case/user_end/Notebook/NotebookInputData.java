package use_case.user_end.Notebook;

import java.time.LocalDateTime;

public class NotebookInputData {
    private String buttonPressed;

    public NotebookInputData(LocalDateTime buttonPressed, String action) {
        this.buttonPressed = buttonPressed;
    }

    String getButtonPressed() { return buttonPressed; }
}
