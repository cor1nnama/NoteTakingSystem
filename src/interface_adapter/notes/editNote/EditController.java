package interface_adapter.notes.editNote;

import use_case.notes.edit_notes.EditInputData;
import use_case.notes.edit_notes.EditNoteInputBoundary;
import entity.Note;

import java.time.LocalDateTime;

public class EditController {
    final EditNoteInputBoundary editInteractor;

    public EditController(EditNoteInputBoundary editInteractor) {
        this.editInteractor = editInteractor;
    }
    public void execute(LocalDateTime creationTime, String title, String content){
        EditInputData editInputData = new EditInputData(creationTime, title, content);
        editInteractor.execute(editInputData);


    }
}
