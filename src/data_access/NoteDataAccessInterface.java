package data_access;

import entity.Notebook;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public interface NoteDataAccessInterface {
    public boolean existsByLDT(LocalDateTime ldt);

    void save(LocalDateTime ldt, Notebook notebook) throws IOException;

    Map<LocalDateTime, String> getNotesInNotebook(LocalDateTime notebookID);

    //add catches for errors for both file methods
    void writeToFile() throws IOException;

    void deleteNotebook(LocalDateTime localDateTime);
    void renameNotebook(LocalDateTime notebookID, String newTitle);

}
