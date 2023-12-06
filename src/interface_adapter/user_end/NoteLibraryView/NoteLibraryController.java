package interface_adapter.user_end.NoteLibraryView;

import use_case.user_end.Note.NoteInputBoundary;
import use_case.user_end.Note.NoteInputData;
import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInputData;

import java.time.LocalDateTime;

public class NoteLibraryController {

    final NoteInputBoundary noteUseCaseInteractor;

    public NoteLibraryController(NoteInputBoundary noteUseCaseInteractor) {
        this.noteUseCaseInteractor = noteUseCaseInteractor;
    }

    public void execute(LocalDateTime selectedNote, String action, LocalDateTime currNotebook) {
        NoteInputData noteInputData = new NoteInputData(selectedNote, action, currNotebook);

        noteUseCaseInteractor.execute(noteInputData);
    }

}
