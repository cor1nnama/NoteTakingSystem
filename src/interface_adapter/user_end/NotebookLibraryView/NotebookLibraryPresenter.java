package interface_adapter.user_end.NotebookLibraryView;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryState;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryViewModel;
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
        noteLibraryState.setNotes(notes.getNotes());
        this.noteLibraryViewModel.setState(noteLibraryState);
        this.noteLibraryViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(noteLibraryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void reloadView() {
        //Updates with new data
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        NotebookLibraryState notebookLibraryState = notebookLibraryViewModel.getState();
        notebookLibraryState.setNoteError(error);
        notebookLibraryViewModel.firePropertyChanged();;
    }
}
