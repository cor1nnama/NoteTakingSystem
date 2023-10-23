package entity;

import java.util.ArrayList;

public class Note {
    public Notebook notebook;
    final public String creationTime;
    public String title;
    final public CommonUser owner;
    public String content;
    public ArrayList<String> tag;
    public boolean trash;

    public Note(Notebook notebook, String creationTime, String title, CommonUser owner){
        this.notebook = notebook;
        this.creationTime = creationTime;
        this.title = title;
        this.owner = owner;
        this.content = new String("");
        this.tag = new ArrayList<String>();
        this.trash = false;
        notebook.notes.add(this);
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrash(boolean trash) {
        this.trash = trash;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public String getContent() {
        return content;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getTitle() {
        return title;
    }

    public CommonUser getOwner() {
        return owner;
    }

    public ArrayList<String> getTag() {
        return tag;
    }
}
