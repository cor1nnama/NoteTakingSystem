package app;

import data_access.NotebookDataAccessInterface;
import entity.NotebookFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.notes.create_notebook.CreateNotebookController;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryPresenter;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import use_case.notes.create_notebook.CreateNotebookInteractor;
import use_case.notes.create_notebook.CreateNotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInteractor;
import use_case.user_end.Notebook.NotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookUserDataAccessInterface;
import view.NotebookView;

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
            CreateNotebookController createNotebookController = createCreateNotebookUseCase(viewManagerModel, notebookLibraryViewModel, noteLibraryViewModel, notebookUserDataAccessInterface,
                    notebookDataAccessInterface);
            return new NotebookView(notebookLibraryViewModel, notebookLibraryController, createNotebookController);
        //} catch (IOException e) {
        //    JOptionPane.showMessageDialog(null, "Error reading user data file");
        //}
        //return null;
    }

    private static CreateNotebookController createCreateNotebookUseCase(ViewManagerModel viewManagerModel,
                                                                        NotebookLibraryViewModel notebookLibraryViewModel,
                                                                        NoteLibraryViewModel noteLibraryViewModel,
                                                                        NotebookUserDataAccessInterface notebookUserDataAccessInterface,
                                                                        NotebookDataAccessInterface notebookDataAccessInterface) {
        NotebookFactory notebookFactory = new NotebookFactory();
        CreateNotebookInteractor createNotebookInteractor = new CreateNotebookInteractor(notebookDataAccessInterface,notebookFactory, notebookLibraryViewModel);
        return new CreateNotebookController(createNotebookInteractor);
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
