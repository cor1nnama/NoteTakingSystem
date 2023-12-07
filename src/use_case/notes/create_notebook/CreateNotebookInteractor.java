package use_case.notes.create_notebook;

import data_access.FileNotebookDataAccessObject;
import data_access.NotebookDataAccessInterface;
import entity.Notebook;
import entity.NotebookFactory;

import java.io.IOException;

public class CreateNotebookInteractor implements CreateNotebookInputBoundary{
    final NotebookDataAccessInterface notebookDataAccessObject;
    final CreateNotebookOutputBoundary notebookPresenter;
    final NotebookFactory notebookFactory;

    public CreateNotebookInteractor(NotebookDataAccessInterface notebookDataAccessObject,
                                    CreateNotebookOutputBoundary createNotebookOutputBoundary,
                                    NotebookFactory notebookFactory){
        this.notebookDataAccessObject = notebookDataAccessObject;
        this.notebookPresenter = createNotebookOutputBoundary;
        this.notebookFactory = notebookFactory;
    }


    @Override
    public void execute(CreateNotebookInputData createNotebookInputData) throws IOException {
        if(notebookDataAccessObject.existsByName(createNotebookInputData.getNotebookName())){
            notebookPresenter.prepareFailView("Notebook already exists.");
        } else{
            Notebook notebook = notebookFactory.create(createNotebookInputData.getNotebookName());
            notebookDataAccessObject.save(notebook.getCreationTime(), notebook);
            CreateNotebookOutputData createNotebookOutputData = new CreateNotebookOutputData(notebook.getName(), false);
            notebookPresenter.prepareSuccessView(createNotebookOutputData);
        }
    }
}
