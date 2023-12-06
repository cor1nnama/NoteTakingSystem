package data_access;

import entity.Notebook;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryNotebookDataAccessObject implements NotebookDataAccessInterface{
    private final Map<String, List<Notebook>> notebookMap = new HashMap<>();
    //@Override
    public boolean existsByName(String identifier) {
        return notebookMap.containsKey(identifier);
    }

    //@Override
    public void save(String username, Notebook notebook) {
        notebookMap.get(username).add(notebook);

    }

    @Override
    public boolean existsByLDT(LocalDateTime ldt) {
        return false;
    }

    @Override
    public void save(LocalDateTime ldt, Notebook notebook) throws IOException {

    }

    @Override
    public Map<LocalDateTime, String> getNotesInNotebook(LocalDateTime notebookID) {
        return null;
    }

    @Override
    public void writeToFile() throws IOException {

    }

    @Override
    public void deleteNotebook(LocalDateTime localDateTime) {

    }

    @Override
    public void renameNotebook(LocalDateTime notebookID, String newTitle) {

    }
}
