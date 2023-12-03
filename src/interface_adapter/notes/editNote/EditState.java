package interface_adapter.notes.editNote;

import entity.Note;

import java.time.LocalDateTime;

public class EditState {
    private boolean editing;
    private LocalDateTime creationTime;

    private String title;

    private String content;

    private String editTitleError = null;

    public EditState(boolean editing, LocalDateTime creationTime){
        this.editing = editing;
        this.creationTime = creationTime;
    }

    public EditState(){};

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public boolean getEditing() {
        return editing;
    }

    public void setEditing(Boolean editing) {
        this.editing = editing;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime= creationTime;
    }

    public void setEditTitleError(String editTitleError) {
        this.editTitleError = editTitleError;
    }

    public String getEditTitleError() {
        return editTitleError;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
}
