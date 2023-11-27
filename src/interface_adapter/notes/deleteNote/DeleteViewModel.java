package interface_adapter.notes.deleteNote;

import interface_adapter.ViewModel;
import interface_adapter.notes.editNote.EditState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteViewModel extends ViewModel {
    private DeleteState state;

    public DeleteViewModel(){super("delete");}

    public void setState(DeleteState state){this.state = state;}

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
