package entity;

public class NotebookFactory {
    public Notebook create(String notebookName){return new Notebook(notebookName);}
}
