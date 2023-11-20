package interface_adapter.user_end.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.logged_in.LoggedInState;
import interface_adapter.user_end.logged_in.LoggedInViewModel;
import use_case.user_end.login.LoginOutputBoundary;
import use_case.user_end.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel,
                             LoginViewModel loginViewModel){
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData user) {
        LoginState loginState = loginViewModel.getState();
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(loginState.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        loggedInViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
