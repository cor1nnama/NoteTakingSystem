package use_case.notes.edit_notes;

public class EditOutputData {
    final private String newNote;

    public EditOutputData(String newNote) {
        this.newNote = newNote;

    }

    public String getNewNote() {
        return newNote;
    }
}
