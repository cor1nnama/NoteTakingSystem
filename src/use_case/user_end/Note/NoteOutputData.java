package use_case.user_end.Note;

import java.time.LocalDateTime;
import java.util.Map;

public class NoteOutputData {

    private final LocalDateTime noteID;
    public NoteOutputData(LocalDateTime noteID) {
        this.noteID = noteID;
    }

    public LocalDateTime getCreationTime() { return  noteID; }
}
