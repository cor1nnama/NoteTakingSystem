package use_case.user_end.Notebook;

import entity.User;

import java.time.LocalDateTime;
import java.util.Map;

public interface NotebookUserDataAccessInterface {


    User get(String username);
}
