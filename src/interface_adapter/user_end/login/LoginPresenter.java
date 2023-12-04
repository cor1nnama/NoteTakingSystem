package interface_adapter.user_end.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.user_end.login.LoginOutputBoundary;
import use_case.user_end.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final NotebookLibraryViewModel notebookLibraryViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                             NotebookLibraryViewModel notebookLibraryViewModel,
                             LoginViewModel loginViewModel){
        this.viewManagerModel = viewManagerModel;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData user) {
        //LoginState loginState = loginViewModel.getState();
        NotebookLibraryState notebookLibraryState = notebookLibraryViewModel.getState();
        notebookLibraryState.setUsername(.getUsername());
        this.notebookLibraryViewModel.setState(notebookLibraryState);
        notebookLibraryViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(notebookLibraryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
