package data_access;

import entity.Note;
import entity.NoteFactory;
import use_case.notes.add_tags.AddTagDataAccessInterface;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface, AddTagDataAccessInterface {
    private final File notesFile;
    private static final String CSV_FILE_PATH = "notes.csv";
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
    public void saveNote(Note note) throws IOException {
        notes.put(note.creationTime, note);
        this.writeToFile();
    }

    //add catches for errors for both file methods
    @Override
    public void writeToFile() throws IOException {
        fsOut = new FileOutputStream(notesFile);
        osOut = new ObjectOutputStream(fsOut);

        for (LocalDateTime ldt : notes.keySet()) {
            osOut.writeObject(notes.get(ldt));
        }

        osOut.close();
        fsOut.close();
    }

    public void readFromFile() throws IOException {
        fsIn = new FileInputStream(notesFile);
        osIn = new ObjectInputStream(fsIn);

        try {
            while (true) { //alternatively (osIn.available() > 0)
                Note noteToAdd = (Note) osIn.readObject();
                notes.put(noteToAdd.creationTime, noteToAdd);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException ignored) {
        }

        osIn.close();
        fsIn.close();

    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }


    @Override
    public ArrayList<Note> getAllNotes() {
        Collection<Note> values= notes.values();
        return new ArrayList<>(values);
    }

    public void saveEdit(Note note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            // Appending data to the CSV file
            writer.write(note.getTitle() + "," + note.getContent());
            writer.newLine();
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
        }
    }

    public Note getNoteByCreationTime(LocalDateTime dateTime){
        Set <LocalDateTime> temp = notes.keySet();
        for (LocalDateTime ldt: temp) {
            if (ldt.equals(dateTime)) {
                return notes.get(ldt);
            }
        }
        return null;

    }
    public void addTag(String tag, LocalDateTime creationTime) {
        Note note = notes.get(creationTime);
        note.setTag(tag);

    }
}
