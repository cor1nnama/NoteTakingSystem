package interface_adapter.notes.editNote;
import interface_adapter.ViewManagerModel;

import interface_adapter.user_end.logged_in.LoggedInViewModel;
import use_case.notes.edit_notes.EditNoteOutputBoundary;
import use_case.notes.edit_notes.EditOutputData;

public class EditPresenter implements EditNoteOutputBoundary {
    private final EditViewModel editViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public EditPresenter(ViewManagerModel viewManagerModel,
                                   EditViewModel editViewModel, LoggedInViewModel loggedInViewModel){
        this.viewManagerModel = viewManagerModel;
        this.editViewModel = editViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }
    @Override
    public void prepareFailView(String s) {
        EditState editState = editViewModel.getState();
        editState.setEditTitleError(s);
        editViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(EditOutputData editOutputData) {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
