package interface_adapter.notes.deleteNote;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.trash.delete_note.DeleteNoteOutputBoundary;
import use_case.trash.delete_note.DeleteNoteOutputData;

public class DeletePresenter implements DeleteNoteOutputBoundary {
    private DeleteViewModel deleteViewModel;
    private NotebookLibraryViewModel notebookLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public void DeleteViewModel(DeleteViewModel deleteViewModel, NotebookLibraryViewModel notebookLibraryViewModel, ViewManagerModel viewManagerModel){
        this.deleteViewModel = deleteViewModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteNoteOutputData deleteNoteOutputData) {
        viewManagerModel.setActiveView(notebookLibraryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
