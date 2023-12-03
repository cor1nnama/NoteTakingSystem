package use_case.trash.delete_note;

import entity.Note;

import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteNoteInteractor  implements  DeleteNoteInputBoundary{
    final DeleteNoteDataAccessInterface deleteNoteDataAccessInterface;
    final DeleteNoteOutputBoundary deletePresenter;

    public DeleteNoteInteractor(DeleteNoteDataAccessInterface deleteNoteDataAccessInterface, DeleteNoteOutputBoundary deletePresenter){
        this.deleteNoteDataAccessInterface = deleteNoteDataAccessInterface;
        this.deletePresenter = deletePresenter;
    }
    @Override
    public void execute(DeleteNoteInputData deleteNoteInputData) throws IOException {
        LocalDateTime creationTime = deleteNoteInputData.getCreationTime();
        Note note = deleteNoteDataAccessInterface.getNoteByCreationTime(creationTime);
        deleteNoteDataAccessInterface.delete(note);
        DeleteNoteOutputData deleteNoteOutputData = null;
        deletePresenter.prepareSuccessView(deleteNoteOutputData);


    }
}
