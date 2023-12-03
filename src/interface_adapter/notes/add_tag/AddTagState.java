package interface_adapter.notes.add_tag;

import java.time.LocalDateTime;

public class AddTagState {
    private LocalDateTime creationTime;

    private String tag;

    private String tagError = null;

    public AddTagState (String tag, LocalDateTime creationTime) {
        this.creationTime = creationTime;
        this.tag = tag;
    }

    public AddTagState(){}

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getTagError() {
        return tagError;
    }

    public String getTag() {
        return tag;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setTagError(String tagError) {
        this.tagError = tagError;
    }
}
