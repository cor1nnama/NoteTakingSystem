package use_case.user_end.Notebook;

import java.time.LocalDateTime;
import java.util.Map;

public interface NotebookUserDataAccessInterface {


    Map<LocalDateTime, String> getNotesInNotebook(LocalDateTime localDateTime);
}
