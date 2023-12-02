package view;

import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NotebookView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "notebook library";
    private String username;
    private final NotebookLibraryViewModel notebookViewModel;
    final JButton trash;
    final JButton edit;
    final JButton open;
    private final NotebookLibraryController notebookLibraryController;

    public NotebookView(NotebookLibraryViewModel notebookLibraryViewModel, NotebookLibraryController notebookLibraryController) {
        this.notebookLibraryController = notebookLibraryController;
        this.notebookViewModel = notebookLibraryViewModel;
        this.notebookViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(username + " Notebooks");
        title.setAlignmentX((Component.CENTER_ALIGNMENT));

        JPanel bottomButtons = new JPanel();

        JPanel notebookButtons = createNotebookButtons();
        JScrollPane notebookLibScroll = new JScrollPane();

    }

    private JPanel createNotebookButtons() {
        for () {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        NotebookLibraryState state = (NotebookLibraryState) evt.getNewValue();
        username = state.getUsername();

    }
}
