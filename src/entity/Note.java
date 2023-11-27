package entity;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Note implements Serializable {
    public String title;
    public ArrayList<String> tags;
    public final LocalDateTime creationTime;
    public String content;

    public Note(String title, ArrayList<String> tags){
        this.title = title;
        this.tags = tags;
        this.creationTime = LocalDateTime.now();
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTag(String tag) { this.tags.add(tag); }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getCreationTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return creationTime.format(format);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String toString() {
        return "Note{" +
                "title=" + title +
                ", tags=" + tags +
                ", creationTime=" + creationTime +
                ", content=" + content +
                "}";
    }
}

