package data_access;

import entity.Notebook;

import java.time.LocalDateTime;
import java.util.Map;

public interface NotebookDataAccessInterface {
    public boolean existsByName(String identifier);
    void save(String username, Notebook notebook);

    Map<LocalDateTime, String> getNotesInNotebook(LocalDateTime notebookID);



}
