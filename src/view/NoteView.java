package view;

import entity.Note;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryController;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryState;
import interface_adapter.user_end.NoteLibraryView.NoteLibraryViewModel;
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
import java.util.Map;

public class NoteView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "notebook library";
    private String username;
    private final NoteLibraryViewModel noteViewModel;
    private LocalDateTime selectedNote;
    final JButton trash;
    final JButton delete;
    final JButton open;
    private final NoteLibraryController noteLibraryController;

    public NoteView(NoteLibraryViewModel noteLibraryViewModel, NoteLibraryController noteLibraryController) {
        this.noteLibraryController = noteLibraryController;
        this.noteViewModel = noteLibraryViewModel;
        this.noteViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(username + " Notes");
        title.setAlignmentX((Component.CENTER_ALIGNMENT));

        JPanel noteButtons = createNotebookButtons();
        JScrollPane noteLibScroll = new JScrollPane();

        for (Component button : noteButtons.getComponents()) {
            JButton currButt = (JButton) button;
            currButt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NoteLibraryState currState = noteLibraryViewModel.getState();
                    selectedNote = currState.getNCreationTime(currButt.getText());

                }
            });
        }

        JPanel bottomButtons = new JPanel();
        bottomButtons.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        trash = new JButton(noteLibraryViewModel.TRASH_BUTTON_LABEL);
        bottomButtons.add(trash);
        delete = new JButton(noteLibraryViewModel.DELETE_BUTTON_LABEL);
        bottomButtons.add(delete);
        open = new JButton(noteLibraryViewModel.OPEN_BUTTON_LABEL);
        bottomButtons.add(open);

        trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(trash)) {
                    NoteLibraryState currState = noteLibraryViewModel.getState();
                    noteLibraryController.execute(selectedNote, noteLibraryViewModel.TRASH_BUTTON_LABEL, currState.getNotebook());
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(delete)) {
                    NoteLibraryState currState = noteLibraryViewModel.getState();
                    noteLibraryController.execute(selectedNote, noteLibraryViewModel.DELETE_BUTTON_LABEL, currState.getNotebook());
                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(open)) {
                    NoteLibraryState currState = noteLibraryViewModel.getState();
                    noteLibraryController.execute(selectedNote, noteLibraryViewModel.OPEN_BUTTON_LABEL, currState.getNotebook());
                }
            }
        });



    }

    private JPanel createNotebookButtons() {
        JPanel buttons = new JPanel();
        Map<LocalDateTime, String> notes = noteViewModel.getState().getNotes();
        for (Map.Entry<LocalDateTime, String> entry : notes.entrySet()) {
            buttons.add(new JButton(entry.getValue()));
        }
        return buttons;
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
