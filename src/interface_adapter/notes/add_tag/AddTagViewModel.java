package interface_adapter.notes.add_tag;

import interface_adapter.ViewModel;
import interface_adapter.notes.editNote.EditState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddTagViewModel extends ViewModel {
    public final String DONE_BUTTON = "Done";
    public final String ENTER_LABEL = "Enter tag here:";


    private AddTagState state = new AddTagState();

    public AddTagViewModel(){super("add tag");}

    public void setState(AddTagState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public AddTagState getState() {
        return state;
    }
}
