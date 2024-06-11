package com.tasawar.mongoClientWithAggr.entities;

public class Bird extends Animal {
    private boolean walks;

    public boolean isWalks() {
        return walks;
    }

    public void setWalks(boolean walks) {
        this.walks = walks;
    }

    public Bird() {
        super("bird");
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    public Bird(String name) {
        super(name);
    }

    public boolean walks() {
        return walks;
    }

    @Override
    protected String getSound() {
        return "CHII CHII";
    }

    @Override
    public String eats() {
        return "Keeray Makoraay";
    }

    // standard setters and overridden methods
}
