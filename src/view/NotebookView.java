package view;

import entity.Note;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NotebookView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "notebook library";
    private String username;
    private final NotebookLibraryViewModel notebookViewModel;
    final JButton trash;
    final JButton delete;
    final JButton edit;
    final JButton open;
    private final NotebookLibraryController notebookLibraryController;

    public NotebookView(NotebookLibraryViewModel notebookLibraryViewModel, NotebookLibraryController notebookLibraryController) {
        this.notebookLibraryController = notebookLibraryController;
        this.notebookViewModel = notebookLibraryViewModel;
        this.notebookViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(username + " Notebooks");
        title.setAlignmentX((Component.CENTER_ALIGNMENT));

        JPanel notebookButtons = createNotebookButtons();
        JScrollPane notebookLibScroll = new JScrollPane();

        JPanel bottomButtons = new JPanel();
        trash = new JButton(notebookLibraryViewModel.TRASH_BUTTON_LABEL);
        bottomButtons.add(trash);
        delete = new JButton(notebookLibraryViewModel.DELETE_BUTTON_LABEL);
        bottomButtons.add(delete);
        edit = new JButton(notebookLibraryViewModel.EDIT_BUTTON_LABEL);
        bottomButtons.add(edit);
        open = new JButton(notebookLibraryViewModel.OPEN_BUTTON_LABEL);
        bottomButtons.add(open);

        trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(trash)) {
                    //NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    notebookLibraryController.execute(notebookLibraryViewModel.TRASH_BUTTON_LABEL);
                }
            }
        });



    }

    private JPanel createNotebookButtons() {
        ArrayList<Note> notebooks = notebookViewModel.getState().getUserNotebooks();
        for (notebook : ;) {


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
