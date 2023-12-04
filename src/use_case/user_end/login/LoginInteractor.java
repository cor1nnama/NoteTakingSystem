package use_case.user_end.login;

import data_access.FileNotebookDataAccessObject;
import data_access.FileUserDataAccessObject;

public class LoginInteractor implements LoginInputBoundary{
    final LoginUserDataAccessInterface userDAO;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDAO,
                           LoginOutputBoundary loginPresenter){
        this.loginPresenter = loginPresenter;
        this.userDAO = userDAO;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        if (!userDAO.existsByName(loginInputData.getUsername())){
            loginPresenter.prepareFailView("User does not exist.");
        } else if (!userDAO.authenticateUser(loginInputData.getUsername(), loginInputData.getPassword())){
           loginPresenter.prepareFailView("Incorrect password.");
        } else {
            LoginOutputData loginOutputData = new LoginOutputData(userDAO.get(loginInputData.getUsername()),
                                                                  userDAO.get(loginInputData.getUsername()).getNotebooks());
            loginPresenter.prepareSuccessView(loginOutputData);
        }
    }
}
