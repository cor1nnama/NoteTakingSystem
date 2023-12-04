package entity;

import java.util.ArrayList;

public interface User{
    // this class states the commonly used method of note-taking users
    void setUsername(String newName);
    void setPassword(String newPassword);
    ArrayList<Notebook> getNotebooks();
    ArrayList<Notebook> setNotebooks();
    String getUsername();
    String getPassword();
}
