package use_case.user_end.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);
    void prepareFailView(String error);
}
