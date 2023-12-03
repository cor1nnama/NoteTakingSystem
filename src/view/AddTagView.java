package view;
import interface_adapter.notes.add_tag.AddTagController;
import interface_adapter.notes.add_tag.AddTagState;
import interface_adapter.notes.add_tag.AddTagViewModel;
import interface_adapter.notes.editNote.EditController;
import interface_adapter.notes.editNote.EditViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;


public class AddTagView extends JPanel implements PropertyChangeListener {
    private AddTagViewModel addTagViewModel;
    private AddTagController addTagController;
    private final JTextField tagInputField = new JTextField(15);
    private JButton done;
    public AddTagView (AddTagViewModel addTagViewModel, AddTagController addTagController) {
        this.addTagViewModel = addTagViewModel;
        this.addTagController = addTagController;
        done = new JButton(addTagViewModel.DONE_BUTTON);
        LabelTextPanel enterTag = new LabelTextPanel(
                new JLabel(addTagViewModel.ENTER_LABEL), tagInputField);
        this.add(done);
        this.add(enterTag);
        done.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(done)) {
                            String tag = tagInputField.getText();
                            AddTagState state = addTagViewModel.getState();
                            LocalDateTime creationTime = state.getCreationTime();
                            state.setTag(tag);

                            addTagController.execute(tag, creationTime);
                        }

                    }
                }
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
