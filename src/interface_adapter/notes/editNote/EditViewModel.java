package interface_adapter.notes.editNote;

import interface_adapter.ViewModel;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditViewModel extends ViewModel {
    public final String SAVE_BUTTON = "Save";


    private EditState state = new EditState();

    public EditViewModel(){super("edit");}

    public void setState(EditState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditState getState(){return state;}
}


