package interface_adapter.notes.create_note;

import use_case.notes.create_note.CreateNoteInputBoundary;
import use_case.notes.create_note.CreateNoteInputData;

public class CreateNoteController {
    final CreateNoteInputBoundary createNoteUseCaseInteractor;
    public CreateNoteController(CreateNoteInputBoundary createNoteUseCaseInteractor) {
        this.createNoteUseCaseInteractor = createNoteUseCaseInteractor;
    }

    public void execute(String title, String tags, String author) {
        CreateNoteInputData createNoteInputData = new CreateNoteInputData(title, tags, author);

        createNoteUseCaseInteractor.execute(createNoteInputData);
    }
}
