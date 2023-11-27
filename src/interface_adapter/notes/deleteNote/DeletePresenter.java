package interface_adapter.notes.deleteNote;

import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditViewModel;
import interface_adapter.user_end.logged_in.LoggedInViewModel;
import use_case.trash.delete_note.DeleteNoteOutputBoundary;
import use_case.trash.delete_note.DeleteNoteOutputData;

public class DeletePresenter implements DeleteNoteOutputBoundary {
    private DeleteViewModel deleteViewModel;
    private LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public void DeleteViewModel(DeleteViewModel deleteViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel){
        this.deleteViewModel = deleteViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteNoteOutputData deleteNoteOutputData) {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
