package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User{
    // this class states the commonly used method of note-taking users
    void setUsername(String newName);
    void setPassword(String newPassword);
    ArrayList<LocalDateTime> getNotebooks();
    void setNotebooks(ArrayList<LocalDateTime> notebooks);
    String getUsername();
    String getPassword();
}
