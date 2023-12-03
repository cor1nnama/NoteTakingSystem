package data_access;

import entity.Notebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryNotebookDataAccessObject implements NotebookDataAccessInterface{
    private final Map<String, List<Notebook>> notebookMap = new HashMap<>();
    @Override
    public boolean existsByName(String identifier) {
        return notebookMap.containsKey(identifier);
    }

    @Override
    public void save(String username, Notebook notebook) {
        notebookMap.get(username).add(notebook);

    }
}
