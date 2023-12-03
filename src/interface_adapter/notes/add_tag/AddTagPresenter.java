package interface_adapter.notes.add_tag;

import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditState;
import interface_adapter.notes.editNote.EditViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.notes.add_tags.AddTagOutputBoundary;
import use_case.notes.add_tags.AddTagOutputData;

public class AddTagPresenter implements AddTagOutputBoundary {
    private final AddTagViewModel addTagViewModel;
    private final NotebookLibraryViewModel notebookLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public AddTagPresenter(ViewManagerModel viewManagerModel,
                         AddTagViewModel addTagViewModel, NotebookLibraryViewModel notebookLibraryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addTagViewModel = addTagViewModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
    }
    @Override
    public void prepareFailView(String s) {
        AddTagState addTagState = addTagViewModel.getState();
        addTagState.setTagError(s);
        addTagViewModel.firePropertyChanged();

    }

    @Override
    public void prepareSuccessView(AddTagOutputData addTagOutputData) {
        viewManagerModel.setActiveView(notebookLibraryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
