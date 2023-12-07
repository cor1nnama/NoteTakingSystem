package use_case.user_end.signup;

import java.io.IOException;

public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData) throws IOException;
}
