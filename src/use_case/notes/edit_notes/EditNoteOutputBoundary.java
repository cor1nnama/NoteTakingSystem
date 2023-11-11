package use_case.notes.edit_notes;

public interface EditNoteOutputBoundary {
    void prepareSuccessView(EditOutputData editOutputData);
    void prepareFailView(String error);

}
