package use_case.notes.add_tags;

import java.time.LocalDateTime;

public class AddTagInputData {
    final private String tag;
    final private LocalDateTime creationTime;

    public AddTagInputData(String tag, LocalDateTime creationTime) {
        this.tag = tag;
        this.creationTime = creationTime;
    }

    public String getTag() {
        return tag;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
