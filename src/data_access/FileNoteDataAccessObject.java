package data_access;

import entity.Note;
import entity.NoteFactory;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface {
    private final File notesFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<LocalDateTime, Note> notes = new LinkedHashMap<>();
    private NoteFactory noteFactory;
    private FileOutputStream fsOut;
    private FileInputStream fsIn;
    private ObjectOutputStream osOut;
    private ObjectInputStream osIn;
    public FileNoteDataAccessObject(String notesPath, NoteFactory noteFactory) throws IOException {
        notesFile = new File(notesPath);
        fsOut = new FileOutputStream(notesPath);
        osOut = new ObjectOutputStream(fsOut);
    }

    @Override
    public void create(Note note) {
        //saves note in memory
    }
//add catches for errors for both file methods
    @Override
    public void writeToFile(Note note) throws IOException {
        fsOut = new FileOutputStream(notesFile);
        osOut = new ObjectOutputStream(fsOut);

        osOut.writeObject(note);

        osOut.close();
        fsOut.close();
    }

    public void readFromFile() throws IOException {
        fsIn = new FileInputStream(notesFile);
        osIn = new ObjectInputStream(fsIn);

        try{
            while (true) { //alternatively (osIn.available() > 0)
                Note noteToAdd = (Note)osIn.readObject();
                notes.put(noteToAdd.creationTime, noteToAdd);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException ignored) {}

        osIn.close();
        fsIn.close();

    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }
}
