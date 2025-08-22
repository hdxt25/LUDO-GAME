package com.example.ludo;

public class App {
    public static void main(String[] args) {
        LudoGame game = new LudoGame(2); // 2 players demo
        game.playAuto();                 // auto-plays and prints to console
    }
}
