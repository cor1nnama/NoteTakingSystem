package interface_adapter.notes.create_notebook;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.logged_in.LoggedInState;
import interface_adapter.user_end.logged_in.LoggedInViewModel;
import use_case.notes.create_notebook.CreateNotebookOutputBoundary;
import use_case.notes.create_notebook.CreateNotebookOutputData;

public class CreateNotebookPresenter implements CreateNotebookOutputBoundary {

    private final CreateNotebookViewModel createNotebookViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateNotebookPresenter(ViewManagerModel viewManagerModel,
                                   CreateNotebookViewModel createNotebookViewModel,
                                   LoggedInViewModel loggedInViewModel){
        this.viewManagerModel = viewManagerModel;
        this.createNotebookViewModel = createNotebookViewModel;
        this.loggedInViewModel = loggedInViewModel;
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
        LoggedInState loggedInState = loggedInViewModel.getState();
        createNotebookState.setNotebookName(createNotebookOutputData.getNotebookName());
        // TODO: Need to add a new button to the loggedInState
        this.createNotebookViewModel.setState(createNotebookState);
        createNotebookViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
