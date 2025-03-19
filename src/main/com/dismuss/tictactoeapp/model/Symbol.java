package com.dismuss.tictactoeapp.model;

/**
 * Symbol from Tic-Tac-Toe com.dismuss.game
 *
 * @author Sergey
 */
public enum Symbol {
    X('X'),
    O('O');

    private final char ch;

    /**
     * @param ch symbol naming
     */
    Symbol(final char ch) {
        this.ch = ch;
    }

    public char getChar() {
        return this.ch;
    }
}
