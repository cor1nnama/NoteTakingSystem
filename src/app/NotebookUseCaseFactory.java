package app;

import data_access.NotebookDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryPresenter;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import interface_adapter.user_end.login.LoginPresenter;
import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInteractor;
import use_case.user_end.Notebook.NotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookUserDataAccessInterface;
import view.NotebookView;

import javax.swing.*;
import java.io.IOException;

public class NotebookUseCaseFactory {

    private NotebookUseCaseFactory() {}

    public static NotebookView create(ViewManagerModel viewManagerModel,
                                      NotebookLibraryViewModel notebookLibraryViewModel,
                                      NoteLibraryViewModel noteLibraryViewModel,
                                      NotebookUserDataAccessInterface notebookUserDataAccessInterface,
                                      NotebookDataAccessInterface notebookDataAccessInterface) {

        //try {
            NotebookLibraryController notebookLibraryController = createNotebookUseCase(viewManagerModel, notebookLibraryViewModel, noteLibraryViewModel, notebookUserDataAccessInterface,
                    notebookDataAccessInterface);
            return new NotebookView(notebookLibraryViewModel, notebookLibraryController);
        //} catch (IOException e) {
        //    JOptionPane.showMessageDialog(null, "Error reading user data file");
        //}
        //return null;
    }

    private static NotebookLibraryController createNotebookUseCase(ViewManagerModel viewManagerModel,
                                                                   NotebookLibraryViewModel notebookLibraryViewModel,
                                                                   NoteLibraryViewModel noteLibraryViewModel,
                                                                   NotebookUserDataAccessInterface notebookUserDataAccessInterface,
                                                                   NotebookDataAccessInterface notebookDataAccessInterface) {

        NotebookOutputBoundary notebookOutputBoundary = new NotebookLibraryPresenter(viewManagerModel, noteLibraryViewModel, notebookLibraryViewModel);
        NotebookInputBoundary notebookInteractor = new NotebookInteractor(notebookDataAccessInterface, notebookUserDataAccessInterface, notebookOutputBoundary);
        return new NotebookLibraryController(notebookInteractor);
    }

}
