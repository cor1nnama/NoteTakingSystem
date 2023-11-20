package entity;

public class NotebookFactory {
    public Notebook create(String notebookName, String username){return new Notebook(notebookName, username);}
}
