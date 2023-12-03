package use_case.notes.create_notebook;

import data_access.FileNotebookDataAccessObject;
import data_access.NotebookDataAccessInterface;
import entity.Notebook;
import entity.NotebookFactory;

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
    public void execute(CreateNotebookInputData createNotebookInputData) {
        if(notebookDataAccessObject.existsByName(createNotebookInputData.getNotebookName())){
            notebookPresenter.prepareFailView("Notebook already exists.");
        } else{
            Notebook notebook = notebookFactory.create(createNotebookInputData.notebookName, createNotebookInputData.owner);
            notebookDataAccessObject.save(notebook);
            CreateNotebookOutputData createNotebookOutputData = new CreateNotebookOutputData(notebook.getName(), false);
            notebookPresenter.prepareSuccessView(createNotebookOutputData);
        }
    }
}
