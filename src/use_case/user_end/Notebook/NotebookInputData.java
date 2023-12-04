package use_case.user_end.Notebook;
public class NotebookInputData {
    private String buttonPressed;

    public NotebookInputData(String buttonPressed) {
        this.buttonPressed = buttonPressed;
    }

    String getButtonPressed() { return buttonPressed; }
}
