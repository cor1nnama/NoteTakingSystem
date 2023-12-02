package interface_adapter.user_end.NotebookLibraryView;

import entity.Notebook;

import java.time.LocalDateTime;
import java.util.Map;

public class NotebookLibraryState {
    private String username = "";

    private Map<LocalDateTime, Notebook> userNotebooks;

    public NotebookLibraryState(NotebookLibraryState copy) {
        username = copy.username;
        userNotebooks = copy.userNotebooks;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NotebookLibraryState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }

    public Map<LocalDateTime, Notebook> getUserNotebooks() {
        return userNotebooks;
    }
    public void setUserNotebooks(Map<LocalDateTime, Notebook> userNotebooks) {
        this.userNotebooks = userNotebooks;
    }
}

