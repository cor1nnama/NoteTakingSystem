package data_access;

import entity.Note;
import entity.NoteFactory;
import use_case.notes.create_note.CreateNoteDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface {
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
    public String open(Note note) {
        return null;
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) { // Assuming CSV format: title,content
                    String title = data[0];
                    String content = data[1];
                    Note note = new Note(title, content);
                    notes.add(note);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notes;
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
        ArrayList <Note> notes = this.getAllNotes();
        for (Note note: notes) {
            if (note.getCreationTime().equals(dateTime)) {
                return note;
            }
        }
        return null;

    }
}
