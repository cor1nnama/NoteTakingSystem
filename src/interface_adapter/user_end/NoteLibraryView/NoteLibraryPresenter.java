package interface_adapter.user_end.NoteLibraryView;

import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditState;
import interface_adapter.notes.editNote.EditViewModel;
import use_case.user_end.Note.NoteOutputBoundary;
import use_case.user_end.Note.NoteOutputData;
import use_case.user_end.Notebook.NotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookOutputData;

public class NoteLibraryPresenter implements NoteOutputBoundary {
    private final NoteLibraryViewModel noteLibraryViewModel;
    private final EditViewModel editViewModel;
    private ViewManagerModel viewManagerModel;
    public NoteLibraryPresenter(ViewManagerModel viewManagerModel,
                                EditViewModel editViewModel,
                                NoteLibraryViewModel notebookLibraryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editViewModel = editViewModel;
        this.noteLibraryViewModel = notebookLibraryViewModel;
    }
    @Override
    public void prepareSuccessView(NoteOutputData note) {
        // On success switch to edit view

        EditState editState = editViewModel.getState();
        editState.setCreationTime(note.getCreationTime());
        this.viewManagerModel.setActiveView(editViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void reloadView() {
        //Updates with new data
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        NoteLibraryState noteLibraryState = noteLibraryViewModel.getState();
        noteLibraryState.setNoteError(error);
        noteLibraryViewModel.firePropertyChanged();;
    }
}
