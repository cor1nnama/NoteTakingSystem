package interface_adapter.notes.add_tag;

import use_case.notes.add_tags.AddTagInputData;
import use_case.notes.add_tags.AddTagInteractor;

import java.time.LocalDateTime;

public class AddTagController {
    final AddTagInteractor addTagInteractor;

    public AddTagController(AddTagInteractor addTagInteractor) {
        this.addTagInteractor = addTagInteractor;
    }
    public void execute(String tag, LocalDateTime creationTime) {
        AddTagInputData addTagInputData = new AddTagInputData(tag, creationTime);
        addTagInteractor.execute(addTagInputData);
    }
}
