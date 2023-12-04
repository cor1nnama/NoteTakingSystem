package use_case.user_end.login;
import entity.Notebook;
import entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class LoginOutputData {
    User user;
    Map<LocalDateTime, String> notebooks;

    public LoginOutputData(User user, Map<LocalDateTime, String> notebooks){
        this.notebooks = notebooks;
        this.user = user;
    }

    public User getUser() { return user; }
    public Map<LocalDateTime, String> getNotebooks() { return notebooks; }

}