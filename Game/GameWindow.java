import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private JTextArea textArea;
    private JTextField inputField;
    private Game game;

    public GameWindow() {
        game = new Game(this);
        setTitle("Your Way Home");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput(inputField.getText());
                inputField.setText("");
            }
        });
        add(inputField, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void processInput(String inputText) {
        game.processPlayerCommand(inputText);
    }

    public void updateDisplay(String text) {
        textArea.append(text + "\n");
    }
}
