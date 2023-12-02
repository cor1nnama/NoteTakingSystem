package use_case.notes.create_note;

import data_access.FileNoteDataAccessObject;
import data_access.FileNotebookDataAccessObject;
import entity.Note;
import entity.NoteFactory;
import use_case.CreateInteractor;

public class CreateNoteInteractor implements CreateNoteInputBoundary {

    final CreateNoteDataAccessInterface noteDAO;
    final NoteFactory noteFactory;
    public CreateNoteInteractor(CreateNoteDataAccessInterface noteDAO,
                                NoteFactory noteFactory) {
        this.noteDAO = noteDAO;
        this.noteFactory = noteFactory;

    }

    @Override
    public void execute(CreateNoteInputData createNoteInputData) {
        if (noteDAO.existsByTitle(createNoteInputData.getTitle())) {
            //notePresenter.prepareFailView("Title already exists.");
        } else {
            Note note = noteFactory.create(createNoteInputData.getTitle(), createNoteInputData.getTags(), createNoteInputData.getDate());
            noteDAO.save(note);
        }
    }
}
