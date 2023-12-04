package interface_adapter.user_end.NotebookLibraryView;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NotebookLibraryViewModel extends ViewModel {
    public final String TITLE_LABEL = "Notebook Library";

    private NotebookLibraryState state = new NotebookLibraryState();
    public static final String LOGOUT_BUTTON_LABEL = "Log Out";
    public static final String DELETE_BUTTON_LABEL = "Delete";
    public static final String TRASH_BUTTON_LABEL = "Trash";
    public static final String EDIT_BUTTON_LABEL = "Edit";
    public static final String OPEN_BUTTON_LABEL = "Open";
    private String currUser;
    public NotebookLibraryViewModel(){super("notebook library");}
    public NotebookLibraryState getState() {
        return this.state;
    }
    public void setState(NotebookLibraryState state) {
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
