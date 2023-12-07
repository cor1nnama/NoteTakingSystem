package data_access;

import entity.Notebook;
import entity.NotebookFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileNotebookDataAccessObject implements NotebookDataAccessInterface{
    private final File notebooksFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<LocalDateTime, Notebook> notebooks = new LinkedHashMap<>();

    private NotebookFactory notebookFactory;
    private FileOutputStream fsOut;
    private FileInputStream fsIn;
    private ObjectOutputStream osOut;
    private ObjectInputStream osIn;


    public FileNotebookDataAccessObject(String notebooksPath, NotebookFactory notebookFactory) throws IOException {
        this.notebookFactory = notebookFactory;
        notebooksFile = new File(notebooksPath);
        fsOut = new FileOutputStream(notebooksPath);
        osOut = new ObjectOutputStream(fsOut);

    }

    //Remove?
    public boolean existsByCreationTime(LocalDateTime ldt) {
        return false;
    }

    @Override
    public void save(LocalDateTime ldt, Notebook notebook) throws IOException {
        notebooks.put(ldt, notebook);
        this.writeToFile();
    }

    @Override
    public Map<LocalDateTime, String> getNotesInNotebook(LocalDateTime notebookID) {
        Notebook notebook = notebooks.get(notebookID);
        return notebook.getNotes();
    }

    //add catches for errors for both file methods
    @Override
    public void writeToFile() throws IOException {
        new FileOutputStream(notebooksFile).close(); //Clears file for fresh data
        fsOut = new FileOutputStream(notebooksFile);
        osOut = new ObjectOutputStream(fsOut);

        for (LocalDateTime ldt : notebooks.keySet()) {
            osOut.writeObject(notebooks.get(ldt));
        }

        osOut.close();
        fsOut.close();
    }

    public void readFromFile() throws IOException {
        fsIn = new FileInputStream(notebooksFile);
        osIn = new ObjectInputStream(fsIn);

        try {
            while (true) { //alternatively (osIn.available() > 0)
                Notebook notebookToAdd = (Notebook) osIn.readObject();
                notebooks.put(notebookToAdd.getCreationTime(), notebookToAdd);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException ignored) {
        }

        osIn.close();
        fsIn.close();

    }

    public Notebook getNotebook(LocalDateTime creationTime) {
        return notebooks.get(creationTime);
    }
    public void deleteNotebook(LocalDateTime creationTime) { notebooks.remove(creationTime); }

    @Override
    public void renameNotebook(LocalDateTime notebookID, String newTitle) {
        notebooks.get(notebookID).name = newTitle;
    }



    @Override
    public boolean existsByLDT(LocalDateTime ldt) {
        return notebooks.containsKey(ldt);
    }
}
