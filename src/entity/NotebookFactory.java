package entity;

public class NotebookFactory {
    public Notebook create(String notebookName, User owner){return new Notebook(notebookName, owner);}
}
