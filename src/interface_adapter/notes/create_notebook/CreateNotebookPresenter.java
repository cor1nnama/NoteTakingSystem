package interface_adapter.notes.create_notebook;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.notes.create_notebook.CreateNotebookOutputBoundary;
import use_case.notes.create_notebook.CreateNotebookOutputData;

public class CreateNotebookPresenter implements CreateNotebookOutputBoundary {

    private final CreateNotebookViewModel createNotebookViewModel;
    private final NotebookLibraryViewModel notebookLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateNotebookPresenter(ViewManagerModel viewManagerModel,
                                   CreateNotebookViewModel createNotebookViewModel,
                                   NotebookLibraryViewModel notebookLibraryViewModel){
        this.viewManagerModel = viewManagerModel;
        this.createNotebookViewModel = createNotebookViewModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
    }
    @Override
    public void prepareFailView(String s) {
        CreateNotebookState createNotebookState = createNotebookViewModel.getState();
        createNotebookState.setNotebookNameError(s);
        createNotebookViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(CreateNotebookOutputData createNotebookOutputData) {
        CreateNotebookState createNotebookState = createNotebookViewModel.getState();
        NotebookLibraryState notebookLibraryState = notebookLibraryViewModel.getState();
        createNotebookState.setNotebookName(createNotebookOutputData.getNotebookName());
        // TODO: Need to add a new button to the loggedInState
        this.createNotebookViewModel.setState(createNotebookState);
        createNotebookViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(notebookLibraryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
