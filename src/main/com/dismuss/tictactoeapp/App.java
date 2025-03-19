package com.dismuss.tictactoeapp;

import com.dismuss.tictactoeapp.element.GameFrame;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
