package use_case.notes.create_notebook;

import data_access.NotebookDataAccessInterface;
import entity.Notebook;
import entity.NotebookFactory;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;

import javax.swing.*;
import java.io.IOException;

public class CreateNotebookInteractor implements CreateNotebookInputBoundary{
    final NotebookDataAccessInterface notebookDataAccessObject;
    final NotebookLibraryViewModel notebookLibraryViewModel;
    final NotebookFactory notebookFactory;

    public CreateNotebookInteractor(NotebookDataAccessInterface notebookDataAccessObject,
                                    NotebookFactory notebookFactory, NotebookLibraryViewModel notebookLibraryViewModel){
        this.notebookDataAccessObject = notebookDataAccessObject;
        this.notebookFactory = notebookFactory;
        this.notebookLibraryViewModel = notebookLibraryViewModel;
    }


    @Override
    public void execute(CreateNotebookInputData createNotebookInputData) throws IOException {
        if(notebookDataAccessObject.existsByName(createNotebookInputData.getNotebookName())){
            JOptionPane.showMessageDialog(null, "Notebook already exists.");
        } else{
            Notebook notebook = notebookFactory.create(createNotebookInputData.getNotebookName());
            notebookDataAccessObject.save(notebook.getCreationTime(), notebook);
            notebookLibraryViewModel.firePropertyChanged();
        }
    }
}
