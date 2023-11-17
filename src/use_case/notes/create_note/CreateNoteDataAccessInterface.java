package use_case.notes.create_note;

import entity.Note;

public interface CreateNoteDataAccessInterface {

    void save(Note note);

    boolean existsByTitle(String title);
}
