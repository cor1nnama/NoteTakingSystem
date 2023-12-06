package use_case.user_end.Note;

import entity.User;

public interface NoteUserDataAccessInterface {


    User get(String username);
}
