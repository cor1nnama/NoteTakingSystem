package app;

import data_access.NoteDataAccessInterface;
import data_access.NotebookDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.notes.editNote.EditViewModel;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryController;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryPresenter;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryViewModel;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryPresenter;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;
import interface_adapter.user_end.login.LoginPresenter;
import use_case.user_end.Note.NoteInputBoundary;
import use_case.user_end.Note.NoteInteractor;
import use_case.user_end.Note.NoteOutputBoundary;
import use_case.user_end.Note.NoteUserDataAccessInterface;
import use_case.user_end.Notebook.NotebookInputBoundary;
import use_case.user_end.Notebook.NotebookInteractor;
import use_case.user_end.Notebook.NotebookOutputBoundary;
import use_case.user_end.Notebook.NotebookUserDataAccessInterface;
import view.NoteView;
import view.NotebookView;

import javax.swing.*;
import java.io.IOException;

public class NoteUseCaseFactory {

    private NoteUseCaseFactory() {}

    public static NoteView create(ViewManagerModel viewManagerModel,
                                  NoteLibraryViewModel noteLibraryViewModel,
                                  EditViewModel editViewModel,
                                  NoteUserDataAccessInterface noteUserDataAccessInterface,
                                  NoteDataAccessInterface noteDataAccessInterface) {

        //try {
            NoteLibraryController noteLibraryController = createNoteUseCase(viewManagerModel, noteLibraryViewModel, editViewModel, noteUserDataAccessInterface,
                    noteDataAccessInterface);
            return new NoteView(noteLibraryViewModel, noteLibraryController);
        //} catch (IOException e) {
         //   JOptionPane.showMessageDialog(null, "Error reading user data file");
        //}
        //return null;
    }

    private static NoteLibraryController createNoteUseCase(ViewManagerModel viewManagerModel,
                                                                   NoteLibraryViewModel noteLibraryViewModel,
                                                                   EditViewModel editViewModel,
                                                                   NoteUserDataAccessInterface noteUserDataAccessInterface,
                                                                   NoteDataAccessInterface noteDataAccessInterface) {

        NoteOutputBoundary noteOutputBoundary = new NoteLibraryPresenter(viewManagerModel, editViewModel, noteLibraryViewModel);
        NoteInputBoundary noteInteractor = new NoteInteractor(noteDataAccessInterface, noteUserDataAccessInterface, noteOutputBoundary);
        return new NoteLibraryController(noteInteractor);
    }

}
