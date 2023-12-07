package app;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.login.LoginViewModel;
import interface_adapter.user_end.signup.SignupController;
import interface_adapter.user_end.signup.SignupViewModel;
import use_case.user_end.signup.SignupInputBoundary;
import use_case.user_end.signup.SignupInteractor;
import interface_adapter.user_end.signup.SignupPresenter;
import use_case.user_end.signup.SignupOutputBoundary;
import use_case.user_end.signup.UserSignupDataAccessInterface;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(ViewManagerModel viewManagerModel,
                                    LoginViewModel loginViewModel,
                                    SignupViewModel signupViewModel,
                                    FileUserDataAccessObject userDAO) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDAO);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            FileUserDataAccessObject userDAO) throws IOException {

        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        UserFactory userFactory = new CommonUserFactory();
        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDAO, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}
