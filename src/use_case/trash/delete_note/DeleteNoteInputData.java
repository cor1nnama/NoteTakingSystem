package use_case.trash.delete_note;


import java.time.LocalDateTime;

public class DeleteNoteInputData {
    final private LocalDateTime creationTime;

    public DeleteNoteInputData(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
