package interface_adapter.notes.editNote;

import entity.Note;

public class EditState {
    private boolean editing;
    private Note note;

    private String editTitleError = null;

    public EditState(boolean editing, Note note){
        this.editing = editing;
        this.note = note;
    }

    public EditState(){};

    public Note getNote() {
        return note;
    }

    public boolean getEditing() {
        return editing;
    }

    public void setEditing(Boolean editing) {
        this.editing = editing;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setEditTitleError(String editTitleError) {
        this.editTitleError = editTitleError;
    }

    public String getEditTitleError() {
        return editTitleError;
    }
}
