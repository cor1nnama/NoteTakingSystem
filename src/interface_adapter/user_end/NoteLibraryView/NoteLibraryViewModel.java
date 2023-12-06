package interface_adapter.user_end.NoteLibraryView;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

public class NoteLibraryViewModel extends ViewModel {
    public final String TITLE_LABEL = "Note Library";

    private NoteLibraryState state = new NoteLibraryState();
    public static final String BACK_BUTTON_LABEL = "Back";
    public static final String DELETE_BUTTON_LABEL = "Delete";
    public static final String TRASH_BUTTON_LABEL = "Trash";
    public static final String OPEN_BUTTON_LABEL = "Open";
    private LocalDateTime currNotebook;
    public NoteLibraryViewModel(){super("notebook library");}
    public NoteLibraryState getState() {
        return this.state;
    }
    public void setState(NoteLibraryState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
