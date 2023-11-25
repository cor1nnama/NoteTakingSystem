package use_case.notes.edit_notes;
import entity.Note;

public class EditInputData {
    final private Note note;
    // I am not sure if we need more input data than this but we probably do, let me know

    public EditInputData(Note note) {
        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}
