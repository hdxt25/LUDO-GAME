package com.example.ludo;

public class Player {
    private final String name;
    private final Color color;
    private final Token token;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.token = new Token();
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Token getToken() {
        return token;
    }
}
