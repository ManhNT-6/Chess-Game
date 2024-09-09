package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame inputFrame = new JFrame("Input Name");
        inputFrame.setSize(600,300);
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Login login = new Login();
        login.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = login.player1Text.getText();
                String lastName = login.player2Text.getText();

                if (firstName.length() != 0 && lastName.length() != 0) {
                    login.frame.dispose();
                    JFrame frame = new JFrame();
                    frame.getContentPane().setBackground(Color.black);
                    frame.setLayout(new GridBagLayout());
                    frame.setMinimumSize(new Dimension(1000,1000));
                    frame.setLocationRelativeTo(null);

                    Board board = new Board();
                    frame.add(board);

                    frame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(inputFrame, "An error happened. Please enter both Player1'name and Player2'name", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
