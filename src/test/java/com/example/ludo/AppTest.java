package com.example.ludo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    void dieRollsInRange() {
        Die d = new Die();
        for (int i = 0; i < 100; i++) {
            int r = d.roll();
            assertTrue(r >= 1 && r <= 6, "Roll must be between 1 and 6");
        }
    }

    @Test
    void tokenMovementRules() {
        Token t = new Token();
        Board b = new Board(10);
        assertTrue(t.isHome());
        t.enterTrackIfSix();
        assertEquals(0, t.getPosition());
        t.move(3, b.getTrackLength());
        assertEquals(3, t.getPosition());
        t.move(7, b.getTrackLength()); // exact end
        assertEquals(10, t.getPosition());
        assertTrue(t.isFinished(b.getTrackLength()));
    }
}
