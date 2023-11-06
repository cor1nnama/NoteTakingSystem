package use_case.notes.create_note;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Arrays;

public class CreateNoteInputData {
    final private String title;
    final private ArrayList<String> tags;
    final private String author;
    final private String date;

    public CreateNoteInputData(String title, String tags, String author) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.title = title;
        this.author = author;
        this.date = now.format(format);
        tags = tags.strip();
        this.tags = new ArrayList<>(Arrays.asList(tags.split("\\s+")));
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }
    public ArrayList<String> getTags() { return tags; }
}
