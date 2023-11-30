package interface_adapter.user_end.NotebookLibraryView;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NotebookLibraryViewModel extends ViewModel {
    public final String TITLE_LABEL = null;

    // TODO: NEED BUTTONS FOR CHOOSING NOTEBOOKS

    private NotebookLibraryState state = new NotebookLibraryState();

    public NotebookLibraryViewModel(){super("loggedIn");}
    public NotebookLibraryState getState() {
        return this.state;
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
