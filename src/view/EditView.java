package view;
import entity.Note;
import interface_adapter.notes.editNote.EditController;
import interface_adapter.notes.editNote.EditPresenter;
import interface_adapter.notes.editNote.EditState;
import interface_adapter.notes.editNote.EditViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditView extends JPanel implements PropertyChangeListener {
    private EditViewModel editViewModel;
    private EditController editController;
    private JButton saveNote;
    public EditView (EditViewModel editViewModel, EditController editController) {
        this.editViewModel = editViewModel;
        this.editController = editController;
        saveNote = new JButton(EditViewModel.SAVE_BUTTON);
        EditState editState = editViewModel.getState();
        Note note = editState.getNote();
        setLayout(new BorderLayout());
        setSize(1152, 600);
        JEditorPane editorPane = new JEditorPane();
        JTextField titleText = new JTextField();
        editorPane.setText(note.getContent());
        titleText.setText(note.getTitle());
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setFont(new Font("Arial", Font.PLAIN, 14));
        titleText.setFont(new Font("Arial", Font.BOLD, 20));
        editorScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(editorScrollPane, BorderLayout.CENTER);
        add(titleText, BorderLayout.NORTH);
        add(saveNote, BorderLayout.SOUTH);
        saveNote.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveNote)) {
                            Note newNote = new Note(titleText.getText(), editViewModel.getState().getNote().getTags());
                            newNote.setContent(editorPane.getText());
                            editController.execute(newNote);
                        }
                    }
                }
        );


    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditState editState = (EditState) evt.getNewValue();
        if (editState.getEditTitleError() != null) {
            JOptionPane.showMessageDialog(this, editState.getEditTitleError());
        }
    }

}
