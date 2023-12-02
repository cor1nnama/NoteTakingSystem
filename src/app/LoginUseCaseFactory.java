package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import interface_adapter.user_end.login.LoginController;
import interface_adapter.user_end.login.LoginPresenter;
import interface_adapter.user_end.login.LoginViewModel;
import use_case.user_end.login.LoginInputBoundary;
import use_case.user_end.login.LoginInteractor;
import use_case.user_end.login.LoginOutputBoundary;
import use_case.user_end.login.LoginUserDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(ViewManagerModel viewManagerModel,
                                   LoginViewModel loginViewModel,
                                   NotebookLibraryViewModel notebookLibraryViewModel,
                                   LoginUserDataAccessInterface userDataAccessObject) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
            LoginController loginController = createUserLoginUseCase(viewManagerModel, loginViewModel, notebookLibraryViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel,
                                                          LoginViewModel loginViewModel,
                                                          NotebookLibraryViewModel notebookLibraryViewModel,
                                                          LoginUserDataAccessInterface userDataAccessObject) throws IOException {
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, notebookLibraryViewModel, loginViewModel);
        UserFactory userFactory = new CommonUserFactory();
        LoginInputBoundary userLoginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(userLoginInteractor);
    }
}
