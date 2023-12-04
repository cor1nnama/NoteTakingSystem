package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public interface User{
    // this class states the commonly used method of note-taking users
    void setUsername(String newName);
    void setPassword(String newPassword);
    Map<LocalDateTime, String> getNotebooks();
    void setNotebooks(Map<LocalDateTime, String> notebooks);
    String getUsername();
    String getPassword();
}
