package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public JFrame frame;
    public JPanel panel;
    public JLabel player1Label, player2Label;
    public JTextField player1Text, player2Text;
    public JButton startButton;
    public Login (){
        // Tạo JFrame

        frame = new JFrame("Name Input Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Đặt JFrame ở giữa màn hình
        frame.setLocationRelativeTo(null);

        // Tạo JPanel với GridBagLayout
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Tạo JLabel và JTextField cho tên đầu tiên
        player1Label = new JLabel("Player 1:");
        player1Text = new JTextField(20);

        // Tạo JLabel và JTextField cho tên cuối cùng
        player2Label = new JLabel("Player 2:");
        player2Text = new JTextField(20);

        // Tạo JButton
        startButton = new JButton("Start");
        startButton.setBackground(Color.green);

        // Thêm các thành phần vào JPanel với GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(player1Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(player1Text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(player2Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(player2Text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(startButton, gbc);

        // Thêm JPanel vào JFrame
        frame.add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
