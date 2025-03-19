package com.dismuss.tictactoeapp.listener;

import com.dismuss.tictactoeapp.element.GameFrame;
import com.dismuss.tictactoeapp.game.TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonClickListener implements ActionListener {
    private final GameFrame gui;
    private final int row;
    private final int col;

    public PlayButtonClickListener(GameFrame gui, int i, int j) {
        this.gui = gui;
        this.row = i;
        this.col = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TicTacToe game = gui.getGame();
        if (game.makeMove(row, col)) {
            gui.updateButton(row, col);
            gui.checkGameStatus();
        }
    }
}
