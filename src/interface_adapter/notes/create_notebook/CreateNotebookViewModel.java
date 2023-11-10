package interface_adapter.notes.create_notebook;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateNotebookViewModel extends ViewModel {
    public final String TITLE_LABEL = "Create Notebook View";
    public final String NOTEBOOK_NAME_LABEL = "Choose Notebook Name";
    public final String CREATE_BUTTON_LABEL = "Create";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private CreateNotebookState state = new CreateNotebookState();

    public CreateNotebookViewModel(){super("create");}

    public void setState(CreateNotebookState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CreateNotebookState getState(){return state;}
}
