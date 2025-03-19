package com.dismuss.tictactoeapp.game;

import com.dismuss.tictactoeapp.model.Symbol;

public class TicTacToe {
    private final char[][] board = new char[3][3];
    private Symbol turn = Symbol.X;
    private boolean gameOver = false;
    private int[][] winningLine = null;

    public TicTacToe() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ' || isGameOver()) {
            return false;
        }
        board[row][col] = turn.getChar();
        if (checkWin(row, col) || isBoardFull()) {
            gameOver = true;
        } else {
            if (turn == Symbol.X) {
                turn = Symbol.O;
            } else {
                turn = Symbol.X;
            }
        }
        return true;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(int row, int col) {
        if (board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            winningLine = new int[][]{{row, 0}, {row, 1}, {row, 2}};
        } else if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            winningLine = new int[][]{{0, col}, {1, col}, {2, col}};
        } else if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winningLine = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        } else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winningLine = new int[][]{{0, 2}, {1, 1}, {2, 0}};
        }
        return winningLine != null;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getField(int row, int col) {
        return board[row][col];
    }

    public int[][] getWinningLine() {
        return winningLine;
    }

    public char getTurn() {
        return turn.getChar();
    }
}
