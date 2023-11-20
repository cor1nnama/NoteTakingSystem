import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.login.LoginViewModel;
import view.LoggedInView;
import view.LoginView;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel);
        views.add(signupView, signupView.viewName);

        LoginView loginView = new LoginView(loginViewModel);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView =

        viewManagerModel.setActiveView(signupView.viewName);
        cardLayout.show(views, viewManagerModel.getActiveView());
        application.pack();
        application.setVisible(true);
    }
}
