package com.example.basketball_stats.classes;

import javafx.beans.property.IntegerProperty;

public class Player extends Person {
    private final IntegerProperty fouls;
    private final IntegerProperty defensiveRebounds;
    private final IntegerProperty offensiveRebounds;
    private final IntegerProperty steals;
    private final IntegerProperty turnOver;
    private final IntegerProperty assists;
    private final IntegerProperty blocks;
    private final IntegerProperty madeFreeThrows;
    private final IntegerProperty attemptedFreeThrows;
    private final IntegerProperty madeTwoPointers;
    private final IntegerProperty attemptedTwoPointers;
    private final IntegerProperty madeThreePointers;
    private final IntegerProperty attemptedThreePointers;
    private final IntegerProperty minutesPlayed;

    /**
     * Costruttore di player che ha come superclass constructor il costruttore con solo firstname e lastname. Poi farò altri costruttori quando li capirò meglio.
     */
    public Player(String firstName, String lastName, IntegerProperty fouls, IntegerProperty defensiveRebounds, IntegerProperty offensiveRebounds, IntegerProperty steals, IntegerProperty turnOver, IntegerProperty assists, IntegerProperty blocks, IntegerProperty madeFreeThrows, IntegerProperty attemptedFreeThrows, IntegerProperty madeTwoPointers, IntegerProperty attemptedTwoPointers, IntegerProperty madeThreePointers, IntegerProperty attemptedThreePointers, IntegerProperty minutesPlayed) {
        super(firstName, lastName);
        this.fouls = fouls;
        this.defensiveRebounds = defensiveRebounds;
        this.offensiveRebounds = offensiveRebounds;
        this.steals = steals;
        this.turnOver = turnOver;
        this.assists = assists;
        this.blocks = blocks;
        this.madeFreeThrows = madeFreeThrows;
        this.attemptedFreeThrows = attemptedFreeThrows;
        this.madeTwoPointers = madeTwoPointers;
        this.attemptedTwoPointers = attemptedTwoPointers;
        this.madeThreePointers = madeThreePointers;
        this.attemptedThreePointers = attemptedThreePointers;
        this.minutesPlayed = minutesPlayed;
    }

    /**
     * Getters and setters
     */
    public int getFouls() {
        return fouls.get();
    }

    public IntegerProperty foulsProperty() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls.set(fouls);
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds.get();
    }

    public IntegerProperty defensiveReboundsProperty() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds.set(defensiveRebounds);
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds.get();
    }

    public IntegerProperty offensiveReboundsProperty() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds.set(offensiveRebounds);
    }

    public int getSteals() {
        return steals.get();
    }

    public IntegerProperty stealsProperty() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals.set(steals);
    }

    public int getTurnOver() {
        return turnOver.get();
    }

    public IntegerProperty turnOverProperty() {
        return turnOver;
    }

    public void setTurnOver(int turnOver) {
        this.turnOver.set(turnOver);
    }

    public int getAssists() {
        return assists.get();
    }

    public IntegerProperty assistsProperty() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists.set(assists);
    }

    public int getBlocks() {
        return blocks.get();
    }

    public IntegerProperty blocksProperty() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks.set(blocks);
    }

    public int getMadeFreeThrows() {
        return madeFreeThrows.get();
    }

    public IntegerProperty madeFreeThrowsProperty() {
        return madeFreeThrows;
    }

    public void setMadeFreeThrows(int madeFreeThrows) {
        this.madeFreeThrows.set(madeFreeThrows);
    }

    public int getAttemptedFreeThrows() {
        return attemptedFreeThrows.get();
    }

    public IntegerProperty attemptedFreeThrowsProperty() {
        return attemptedFreeThrows;
    }

    public void setAttemptedFreeThrows(int attemptedFreeThrows) {
        this.attemptedFreeThrows.set(attemptedFreeThrows);
    }

    public int getMadeTwoPointers() {
        return madeTwoPointers.get();
    }

    public IntegerProperty madeTwoPointersProperty() {
        return madeTwoPointers;
    }

    public void setMadeTwoPointers(int madeTwoPointers) {
        this.madeTwoPointers.set(madeTwoPointers);
    }

    public int getAttemptedTwoPointers() {
        return attemptedTwoPointers.get();
    }

    public IntegerProperty attemptedTwoPointersProperty() {
        return attemptedTwoPointers;
    }

    public void setAttemptedTwoPointers(int attemptedTwoPointers) {
        this.attemptedTwoPointers.set(attemptedTwoPointers);
    }

    public int getMadeThreePointers() {
        return madeThreePointers.get();
    }

    public IntegerProperty madeThreePointersProperty() {
        return madeThreePointers;
    }

    public void setMadeThreePointers(int madeThreePointers) {
        this.madeThreePointers.set(madeThreePointers);
    }

    public int getAttemptedThreePointers() {
        return attemptedThreePointers.get();
    }

    public IntegerProperty attemptedThreePointersProperty() {
        return attemptedThreePointers;
    }

    public void setAttemptedThreePointers(int attemptedThreePointers) {
        this.attemptedThreePointers.set(attemptedThreePointers);
    }

    public int getMinutesPlayed() {
        return minutesPlayed.get();
    }

    public IntegerProperty minutesPlayedProperty() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed.set(minutesPlayed);
    }
}
