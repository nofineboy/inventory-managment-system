package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UIExample {

    private JFrame window;
    private JPanel boardPanel;
    private JButton[] buttons;
    private ArrayList<Integer> playerOneMoves;
    private ArrayList<Integer> playerTwoMoves;
    private int flag = 1; 

    public UIExample() {
        
        window = new JFrame("Tic-Tac-Toe Example");
        boardPanel = new JPanel();
        buttons = new JButton[9];
        playerOneMoves = new ArrayList<>();
        playerTwoMoves = new ArrayList<>();

    
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));

        
        for (int i = 0; i < 9; i++) {
            int index = i + 1; 
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].setFocusPainted(false);

            buttons[i].addActionListener((ActionEvent e) -> {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton.getText().equals("")) {
                    if (flag == 1) {
                        clickedButton.setText("X");
                        playerOneMoves.add(index);
                        flag = 2;
                    } else {
                        clickedButton.setText("O");
                        playerTwoMoves.add(index);
                        flag = 1;
                    }

                    System.out.println("Player One: " + playerOneMoves);
                    System.out.println("Player Two: " + playerTwoMoves);
                } else {
                    JOptionPane.showMessageDialog(window, "Cell already taken!");
                }
            });

            boardPanel.add(buttons[i]);
        }

        window.add(boardPanel);
        window.setSize(400, 400);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UIExample::new);
    }
}