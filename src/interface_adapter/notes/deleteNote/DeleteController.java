package interface_adapter.notes.deleteNote;

import entity.Note;
import use_case.notes.edit_notes.EditInputData;
import use_case.notes.edit_notes.EditNoteInputBoundary;
import use_case.trash.delete_note.DeleteNoteInputBoundary;
import use_case.trash.delete_note.DeleteNoteInputData;

import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteController {
    final DeleteNoteInputBoundary deleteInteractor;

    public DeleteController(DeleteNoteInputBoundary deleteInteractor) {
        this.deleteInteractor = deleteInteractor;
    }
    public void execute(LocalDateTime creationTime) throws IOException {
        DeleteNoteInputData deleteInputData = new DeleteNoteInputData(creationTime);
        deleteInteractor.execute(deleteInputData);


    }
}
