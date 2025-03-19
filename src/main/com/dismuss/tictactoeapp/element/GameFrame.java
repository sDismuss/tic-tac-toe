package com.dismuss.tictactoeapp.element;

import com.dismuss.tictactoeapp.game.TicTacToe;
import com.dismuss.tictactoeapp.listener.PlayButtonClickListener;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private TicTacToe game;
    private final JButton[][] grid = new JButton[3][3];
    private JLabel statusLabel;

    public GameFrame() {
        initUI();
    }

    private void initUI() {
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.game = new TicTacToe();
        initializeGrid();
        initializeStatusBar();
        setVisible(true);
    }

    private void initializeGrid() {
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton newButton = new JButton();
                newButton.setFont(new Font("Arial", Font.BOLD, 60));
                newButton.setFocusPainted(false);
                newButton.setBackground(new Color(240, 240, 240));
                newButton.setOpaque(true);
                newButton.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
                newButton.addActionListener(new PlayButtonClickListener(this, i, j));
                grid[i][j] = newButton;
                boardPanel.add(grid[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
    }

    private void initializeStatusBar() {
        statusLabel = new JLabel("Player X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(220, 220, 220));
        add(statusLabel, BorderLayout.SOUTH);
    }

    public void updateButton(int row, int col) {
        char field = game.getField(row, col);
        grid[row][col].setText(String.valueOf(field));
        grid[row][col].setForeground(field == 'X' ? new Color(42, 62, 80) : new Color(231, 76, 60));
    }

    public void checkGameStatus() {
        if (this.game.isGameOver()) {
            int[][] winningLine = game.getWinningLine();
            if (winningLine != null) {
                highlightWinningLine(winningLine);
                JOptionPane.showMessageDialog(this, "Player " + game.getTurn() + " wins!");
            } else {
                JOptionPane.showMessageDialog(this, "It's a tie!");
            }
            disableAllButtons();
        } else {
            statusLabel.setText("Player " + game.getTurn() + "'s Turn");
        }
    }

    private void highlightWinningLine(int[][] winningLine) {
        for (int[] cell : winningLine) {
            this.grid[cell[0]][cell[1]].setBackground(new Color(46, 204, 113));
        }
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.game.getField(i, j) == ' ') {
                    this.grid[i][j].setEnabled(false);
                }
            }
        }
    }

    public TicTacToe getGame() {
        return game;
    }
}
