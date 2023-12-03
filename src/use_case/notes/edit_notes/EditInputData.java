package use_case.notes.edit_notes;
import entity.Note;

import java.time.LocalDateTime;

public class EditInputData {
    final private LocalDateTime creationTime;
    final private String title;

    final private String content;
    // I am not sure if we need more input data than this but we probably do, let me know

    public EditInputData(LocalDateTime creationTime, String title, String content) {

        this.creationTime = creationTime;
        this.title = title;
        this.content = content;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
