package com.example.ludo;

public class Token {
    // -1 = at home, 0..(trackLength-1) = on track, trackLength = reached end
    private int position = -1;

    public int getPosition() {
        return position;
    }

    public boolean isHome() {
        return position < 0;
    }

    public boolean isFinished(int trackLength) {
        return position >= trackLength;
    }

    public void enterTrackIfSix() {
        if (position < 0) position = 0;
    }

    public void move(int steps, int trackLength) {
        if (isFinished(trackLength)) return;
        int next = position + steps;
        if (next <= trackLength) {
            position = next;
        }
        // simple rule: must land exactly on end; if overshoot, stay
    }
}
