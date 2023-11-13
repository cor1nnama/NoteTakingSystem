package data_access;

import entity.Notebook;

public interface NotebookDataAccessInterface {
    public boolean existsByName(String identifier);
    void save(Notebook notebook);
}
