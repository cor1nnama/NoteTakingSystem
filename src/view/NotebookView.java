package view;

import entity.Note;
import interface_adapter.notes.create_notebook.CreateNotebookController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryController;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryState;
import interface_adapter.user_end.NotebookLibraryView.NotebookLibraryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class NotebookView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "notebook library";
    private String username;
    private final NotebookLibraryViewModel notebookViewModel;
    private LocalDateTime selectedNotebook;
    final JButton trash;
    final JButton delete;
    final JButton edit;
    final JButton open;
    final JButton create;
    final Dimension MIN_SIZE =  new Dimension(100,50);
    final NotebookLibraryController notebookLibraryController;
    final CreateNotebookController createNotebookController;

    public NotebookView(NotebookLibraryViewModel notebookLibraryViewModel, NotebookLibraryController notebookLibraryController, CreateNotebookController createNotebookController) {
        this.setVisible(false);
        this.notebookLibraryController = notebookLibraryController;
        this.createNotebookController = createNotebookController;
        this.notebookViewModel = notebookLibraryViewModel;
        this.notebookViewModel.addPropertyChangeListener(this);
        username = notebookLibraryViewModel.getState().getUsername();

        JLabel title = new JLabel(username + " Notebooks");
        JPanel notebookButtons = createNotebookButtons();


        for (Component button : notebookButtons.getComponents()) {
            JButton currButt = (JButton) button;
            currButt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    selectedNotebook = currState.getNBCreationTime(currButt.getText());

                }
            });
        }
        notebookButtons.setLayout(new FlowLayout());
        JScrollPane notebookLibScroll = new JScrollPane(notebookButtons);
        this.add(notebookLibScroll);

        JPanel bottomButtons = new JPanel();
        bottomButtons.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        trash = new JButton(notebookLibraryViewModel.TRASH_BUTTON_LABEL);
        trash.setMinimumSize(MIN_SIZE);
        bottomButtons.add(trash);
        delete = new JButton(notebookLibraryViewModel.DELETE_BUTTON_LABEL);
        bottomButtons.add(delete);
        edit = new JButton(notebookLibraryViewModel.EDIT_BUTTON_LABEL);
        bottomButtons.add(edit);
        open = new JButton(notebookLibraryViewModel.OPEN_BUTTON_LABEL);
        bottomButtons.add(open);
        create = new JButton(notebookLibraryViewModel.CREATE_BUTTON_LABEL);
        bottomButtons.add(create);

        trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(trash)) {
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    notebookLibraryController.execute(selectedNotebook, notebookLibraryViewModel.TRASH_BUTTON_LABEL, currState.getUsername());
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(delete)) {
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    notebookLibraryController.execute(selectedNotebook, notebookLibraryViewModel.DELETE_BUTTON_LABEL, currState.getUsername());
                }
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(edit)) {
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    notebookLibraryController.execute(selectedNotebook, notebookLibraryViewModel.EDIT_BUTTON_LABEL, currState.getUsername());
                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(open)) {
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    notebookLibraryController.execute(selectedNotebook, notebookLibraryViewModel.OPEN_BUTTON_LABEL, currState.getUsername());
                }
            }
        });
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(create)) {
                    String title = JOptionPane.showInputDialog("Enter Title");
                    NotebookLibraryState currState = notebookLibraryViewModel.getState();
                    try {
                        createNotebookController.execute(title, currState.getUsername());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(bottomButtons, BorderLayout.SOUTH);
        this.add(notebookLibScroll, BorderLayout.CENTER);
        this.setVisible(true);

    }

    private JPanel createNotebookButtons() {
        JPanel buttons = new JPanel();
        Map<LocalDateTime, String> notebooks = notebookViewModel.getState().getUserNotebooks();
        for (Map.Entry<LocalDateTime, String> entry : notebooks.entrySet()) {
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
        setFields(state);

    }

    private void setFields(NotebookLibraryState state) {
        username = state.getUsername();

    }
}
