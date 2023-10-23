package use_case.notes.create_note;

import data_access.FileNoteDataAccessObject;
import data_access.FileNotebookDataAccessObject;
import entity.NoteFactory;
import use_case.CreateInteractor;

public class CreateNoteInteractor implements CreateNoteInputBoundary {

    final FileNoteDataAccessObject noteDAO;
    final FileNotebookDataAccessObject notebookDAO;
    final NoteFactory noteFactory;
    public CreateNoteInteractor(FileNoteDataAccessObject noteDAO, FileNotebookDataAccessObject notbookDAO,
                                NoteFactory noteFactory) {
        this.noteDAO = noteDAO;
        this.notebookDAO = notbookDAO;
        this.noteFactory = noteFactory;

    }

    @Override
    public void execute(CreateNoteInputData createNoteInputData) {

    }
}
