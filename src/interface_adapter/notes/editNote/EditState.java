package interface_adapter.notes.editNote;

import entity.Note;
import view.EditView;

import java.time.LocalDateTime;

public class EditState {
    private LocalDateTime creationTime;

    private String title;

    private String content;

    private String editTitleError = null;

    public EditState(LocalDateTime creationTime, String title, String content){
        this.creationTime = creationTime;
        this.title = title;
        this.content = content;
    }

    public EditState(){};

    public LocalDateTime getCreationTime() {
        return creationTime;
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
