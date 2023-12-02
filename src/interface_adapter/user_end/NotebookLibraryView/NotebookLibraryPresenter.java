package interface_adapter.user_end.NotebookLibraryView;

import interface_adapter.ViewManagerModel;
import use_case.user_end.Notebook.NotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookOutputData;

public class NotebookLibraryPresenter implements NotebookOutputBoundary {
    private final NotebookLibraryViewModel notebookLibraryViewModel;
    private final NoteLibraryViewModel noteLibraryViewModel;
    private ViewManagerModel viewManagerModel;
    public NotebookLibraryPresenter(ViewManagerModel viewManagerModel,
                                    NoteLibraryViewModel noteLibraryViewModel,
                                    NotebookLibraryViewModel notebookLibraryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.noteLibraryViewModel = noteLibraryViewModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
    }
    @Override
    public void prepareSuccessView(NotebookOutputData notes) {
        // On success switch to notes view

        NoteLibraryState noteLibraryState = noteLibraryViewModel.getState();
        noteLibraryState.setNotes(notes);
        this.noteLibraryViewModel.setState(noteState);
        this.noteLibraryViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(noteLibraryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        NotebookLibraryState notebookLibraryState = notebookLibraryViewModel.getState();
        notebookLibraryState.setNoteError(error);
        notebookLibraryViewModel.firePropertyChanged();;
    }
}
