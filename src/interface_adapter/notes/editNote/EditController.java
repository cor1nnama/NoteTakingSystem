package interface_adapter.notes.editNote;

import use_case.notes.edit_notes.EditInputData;
import use_case.notes.edit_notes.EditNoteInputBoundary;
import entity.Note;

public class EditController {
    final EditNoteInputBoundary editInteractor;

    public EditController(EditNoteInputBoundary editInteractor) {
        this.editInteractor = editInteractor;
    }
    public void execute(Note note){
        EditInputData editInputData = new EditInputData(note);
        editInteractor.execute(editInputData);


    }
}
