package use_case.notes.edit_notes;

public class EditInputData {
    final private String newNote;
    // I am not sure if we need more input data than this but we probably do, let me know

    public EditInputData(String newNote, String originalNote) {
        this.newNote = newNote;
    }

    public String getNewNote() {
        return newNote;
    }
}
