package com.dismuss.tictactoeapp.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeTest {
    TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    @DisplayName("Check gameOver variable when game is not over")
    void checkIsGameOverIsFalse() {
        assertTrue(ticTacToe.makeMove(0, 0));
        assertTrue(ticTacToe.makeMove(1, 0));
        assertFalse(ticTacToe.isGameOver());
    }

    @Test
    @DisplayName("Check makeMove on the same field")
    void checkMakeMove() {
        assertTrue(ticTacToe.makeMove(1, 0));
        assertFalse(ticTacToe.makeMove(1, 0));
    }

    @Test
    @DisplayName("Check 'X' player wins")
    void checkXWins() {
        assertTrue(ticTacToe.makeMove(0, 0));
        assertTrue(ticTacToe.makeMove(1, 0));
        assertTrue(ticTacToe.makeMove(0, 1));
        assertTrue(ticTacToe.makeMove(1, 1));
        assertTrue(ticTacToe.makeMove(0, 2));
        assertTrue(ticTacToe.isGameOver());
    }

    @Test
    @DisplayName("Check 'O' player wins")
    void checkOWins() {
        assertTrue(ticTacToe.makeMove(1, 0));
        assertTrue(ticTacToe.makeMove(0, 0));
        assertTrue(ticTacToe.makeMove(1, 1));
        assertTrue(ticTacToe.makeMove(0, 1));
        assertTrue(ticTacToe.makeMove(2, 0));
        assertTrue(ticTacToe.makeMove(0, 2));
        assertTrue(ticTacToe.isGameOver());
    }
}