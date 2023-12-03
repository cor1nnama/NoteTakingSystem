package use_case.user_end.login;

import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    @Test
    void successTest() {
        LoginInputData inputData = new LoginInputData("Imtiaz", "password_I");
        LoginUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

            // This creates a successPresenter that tests whether the test case is as we expect.
            LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
                @Override
                public void prepareSuccessView(LoginOutputData loginOutputData) {
                    // 2 things to check: the output data is correct, and the user has been created in the DAO.
                    assertEquals("Imtiaz", loginOutputData.getUsername());
                    assertTrue(userRepo.existsByName("Imtiaz"));
                }

                @Override
                public void prepareFailView(String error) {
                    fail("Use case failure is unexpected.");
                }
            };

            LoginInputBoundary interactor = new LoginInteractor(userRepo, successPresenter);
            interactor.execute(inputData);
        }

        @Test
        void failureUserDoesNotExistTest() {
            LoginInputData inputData = new LoginInputData("Paul", "password_I");
            LoginUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();
            LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
                @Override
                public void prepareSuccessView(LoginOutputData loginOutputData) {
                    fail("Use case success is unexpected.");
                }

                @Override
                public void prepareFailView(String error) {
                    assertEquals("User does not exist.", error);
                }
            };

            LoginInputBoundary interactor = new LoginInteractor(userRepo, failurePresenter);
            interactor.execute(inputData);
        }

    @Test
    void failureWrongPasswordTest() {
        LoginInputData inputData = new LoginInputData("Daniel", "password_23");
        LoginUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect password.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }

}
