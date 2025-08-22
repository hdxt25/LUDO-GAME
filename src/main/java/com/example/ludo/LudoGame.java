package com.example.ludo;

import java.util.ArrayList;
import java.util.List;

public class LudoGame {
    private final Board board;
    private final Die die = new Die();
    private final List<Player> players = new ArrayList<>();
    private int current = 0;

    public LudoGame(int numPlayers) {
        this.board = new Board(56); // simplified standard track length
        Color[] palette = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        for (int i = 0; i < numPlayers && i < palette.length; i++) {
            players.add(new Player("Player " + (i + 1), palette[i]));
        }
    }

    public void playAuto() {
        System.out.println("Starting Ludo! First to finish wins. Track length: " + board.getTrackLength());
        while (true) {
            Player p = players.get(current);
            int roll = die.roll();
            System.out.printf("%s (%s) rolls: %d%n", p.getName(), p.getColor(), roll);

            Token t = p.getToken();
            if (t.isHome()) {
                if (roll == 6) {
                    t.enterTrackIfSix();
                    System.out.printf("  -> %s enters the board at position 0%n", p.getName());
                    // extra turn on six
                    continue;
                } else {
                    System.out.println("  -> Still at home (need a 6 to enter).");
                }
            } else {
                int before = t.getPosition();
                int target = before + roll;
                if (target <= board.getTrackLength()) {
                    t.move(roll, board.getTrackLength());
                    System.out.printf("  -> Moves from %d to %d%n", before, t.getPosition());
                    if (t.isFinished(board.getTrackLength())) {
                        System.out.printf("🎉 %s WINS!%n", p.getName());
                        break;
                    }
                } else {
                    System.out.printf("  -> Overshoot (needs exact %d). Stay at %d%n", board.getTrackLength(), before);
                }
                if (roll == 6) {
                    System.out.println("  -> Rolled a 6: extra turn!");
                    continue;
                }
            }
            nextTurn();
        }
    }

    private void nextTurn() {
        current = (current + 1) % players.size();
    }
}
