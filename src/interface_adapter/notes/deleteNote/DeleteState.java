package interface_adapter.notes.deleteNote;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeleteState {
    private LocalDateTime creationTime;

    public DeleteState(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
