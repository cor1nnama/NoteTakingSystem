package use_case.user_end.Note;

public interface NoteOutputBoundary {
    void prepareSuccessView(NoteOutputData notes);
    void prepareFailView(String error);

    void reloadView();
}
