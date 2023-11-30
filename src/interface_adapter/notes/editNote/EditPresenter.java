package interface_adapter.notes.editNote;
import interface_adapter.ViewManagerModel;

import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.notes.edit_notes.EditNoteOutputBoundary;
import use_case.notes.edit_notes.EditOutputData;

public class EditPresenter implements EditNoteOutputBoundary {
    private final EditViewModel editViewModel;
    private final NotebookLibraryViewModel notebookLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public EditPresenter(ViewManagerModel viewManagerModel,
                                   EditViewModel editViewModel, NotebookLibraryViewModel notebookLibraryViewModel){
        this.viewManagerModel = viewManagerModel;
        this.editViewModel = editViewModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
    }
    @Override
    public void prepareFailView(String s) {
        EditState editState = editViewModel.getState();
        editState.setEditTitleError(s);
        editViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(EditOutputData editOutputData) {
        viewManagerModel.setActiveView(notebookLibraryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
