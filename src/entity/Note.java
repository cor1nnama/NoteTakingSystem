package entity;

import java.util.ArrayList;

public class Note {
    public Notebook notebook;
    public String creationTime;
    public String title;
    public CommonUser owner;
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
    }
}
