package view;

import interface_adapter.user_end.signup.SignupController;
import interface_adapter.user_end.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.user_end.signup.SignupViewModel;


public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;

    private final JButton signUp;
    private final JButton cancel;

    public SignupView(SignupController controller, SignupViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(signupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        JPanel buttons = new JPanel();
        signUp = new JButton(signupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(signupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        // This makes a new KeyListener object and makes it listen to keystrokes
        // in the usernameInputField. We're actually creating an anonymous class
        // here that is a subclass of KeyListener. Notice how it has access to
        // instance variables in the enclosing class.
        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SignupState currentState = signupViewModel.getState();
                    currentState.setUsername(usernameInputField.getText());
                    signupViewModel.setState(currentState);
                });
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        passwordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SignupState currentState = signupViewModel.getState();
                    currentState.setPassword(String.valueOf(passwordInputField.getPassword()));
                    signupViewModel.setState(currentState);
                });
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        repeatPasswordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SignupState currentState = signupViewModel.getState();
                    currentState.setRepeatPassword(String.valueOf(repeatPasswordInputField.getPassword()));
                    signupViewModel.setState(currentState);
                });
            }


            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(signUp)) {
//            signupController.execute(usernameInputField.getText(),
//                    String.valueOf(passwordInputField.getPassword()),
//                    String.valueOf(repeatPasswordInputField.getPassword()));
            String username = signupViewModel.getState().getUsername();
            String password = signupViewModel.getState().getPassword();
            String repeatPassword = signupViewModel.getState().getRepeatPassword();
            signupController.execute(username, password, repeatPassword);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}
