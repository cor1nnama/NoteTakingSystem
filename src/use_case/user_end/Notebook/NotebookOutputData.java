package use_case.user_end.Notebook;

import java.time.LocalDateTime;
import java.util.Map;

public class NotebookOutputData {

    private final Map<LocalDateTime, String> notes;
    public NotebookOutputData(Map<LocalDateTime, String> notes) {
        this.notes = notes;
    }

    public Map<LocalDateTime, String> getNotes() {return  notes; }
}
