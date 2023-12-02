package app;

import data_access.FileNoteDataAccessObject;
import data_access.FileNotebookDataAccessObject;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.NoteFactory;
import entity.NotebookFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import interface_adapter.user_end.login.LoginViewModel;
import interface_adapter.user_end.signup.SignupViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.
        JFrame application = new JFrame("Note Taking System");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        NotebookLibraryViewModel notebookLibraryViewModel = new NotebookLibraryViewModel();
        EditViewModel editViewModel = new EditViewModel();
        NoteLibraryViewModel noteLibraryViewModel = new NoteLibraryViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        //Construction of the DAOs
        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileNoteDataAccessObject noteDataAccessObject;
        try {
            noteDataAccessObject = new FileNoteDataAccessObject("./notes.txt", new NoteFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileNotebookDataAccessObject notebookDataAccessObject;
        try {
            notebookDataAccessObject = new FileNotebookDataAccessObject("./notebooks.txt", new NotebookFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Constructing views
        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, notebookLibraryViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        NotebookView notebookView = NotebookUseCaseFactory.create(viewManagerModel, notebookLibraryViewModel, noteLibraryViewModel, userDataAccessObject);
        views.add(notebookView, notebookView.viewName);

        NoteView noteView = NoteUseCaseFactory.create(viewManagerModel, notebookLibraryViewModel, editViewModel, userDataAccessObject);
        views.add(noteView, noteView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        cardLayout.show(views, viewManagerModel.getActiveView());
        application.pack();
        application.setVisible(true);
    }
}
