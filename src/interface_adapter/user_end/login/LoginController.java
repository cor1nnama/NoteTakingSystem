package interface_adapter.user_end.login;

import use_case.user_end.login.LoginInputBoundary;
import use_case.user_end.login.LoginInputData;

public class LoginController {
    final LoginInputBoundary loginInteractor;
    public LoginController(LoginInputBoundary loginInteractor){
        this.loginInteractor = loginInteractor;
    }

    public void execute(String username, String password){
        LoginInputData loginInputData = new LoginInputData(username, password);
        loginInteractor.execute(loginInputData);
    }
}
