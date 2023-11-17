package entity;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Note {
    public String title;
    public ArrayList<String> tags;
    final public LocalDateTime creationTime;
    final public CommonUser owner;
    public String content;

    public Note(String title, ArrayList<String> tags, CommonUser owner){
        this.title = title;
        this.tags = tags;
        this.owner = owner;
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

    public CommonUser getOwner() {
        return owner;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
