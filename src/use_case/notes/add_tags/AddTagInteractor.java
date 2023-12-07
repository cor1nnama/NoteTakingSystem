package use_case.notes.add_tags;

import entity.Note;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddTagInteractor implements AddTagInputBoundary {

    final AddTagDataAccessInterface addTagDataAccessInterface;
    final AddTagOutputBoundary addTagPresenter;

    public AddTagInteractor(AddTagDataAccessInterface addTagDataAccessInterface, AddTagOutputBoundary addTagPresenter) {
        this.addTagDataAccessInterface = addTagDataAccessInterface;
        this.addTagPresenter = addTagPresenter;
    }

    @Override
    public void execute(AddTagInputData addTagNoteInputData) throws IOException {
        String tag = addTagNoteInputData.getTag();
        LocalDateTime creationTime = addTagNoteInputData.getCreationTime();
        Note note = addTagDataAccessInterface.getNoteByCreationTime(creationTime);
        if (note.getTags().contains(tag)) {
            addTagPresenter.prepareFailView("Tag already exists");
        }
        else {
            addTagDataAccessInterface.addTag(tag, creationTime);
            addTagPresenter.prepareSuccessView(null);
        }
    }
}
