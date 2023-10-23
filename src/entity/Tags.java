package entity;

import java.util.ArrayList;

public class Tags {
    public String name;
    public ArrayList<Note> tagged;
    public Tags(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Note> getTagged() {
        return tagged;
    }

    public void setName(String name) {
        this.name = name;
    }
}
