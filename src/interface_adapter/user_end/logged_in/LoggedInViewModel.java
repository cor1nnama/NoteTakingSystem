package interface_adapter.user_end.logged_in;

import interface_adapter.ViewModel;
import interface_adapter.notes.create_notebook.CreateNotebookState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = null;

    // TODO: NEED BUTTONS FOR CHOOSING NOTEBOOKS

    private LoggedInState state = new LoggedInState();

    public LoggedInViewModel(){super("loggedIn");}
    public LoggedInState getState() {
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
