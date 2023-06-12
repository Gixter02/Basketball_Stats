package com.example.basketball_stats.classes;

import javafx.beans.property.IntegerProperty;

public class Player extends Person {
    private IntegerProperty playerNumber;
    private IntegerProperty fouls;
    private IntegerProperty defensiveRebounds;
    private IntegerProperty offensiveRebounds;
    private IntegerProperty steals;
    private IntegerProperty turnOver;
    private IntegerProperty assists;
    private IntegerProperty blocks;
    private IntegerProperty madeFreeThrows;
    private IntegerProperty attemptedFreeThrows;
    private IntegerProperty madeTwoPointers;
    private IntegerProperty attemptedTwoPointers;
    private IntegerProperty madeThreePointers;
    private IntegerProperty attemptedThreePointers;
    private IntegerProperty minutesPlayed;

    /**
     * This will be the most used constructor, as it will be called to insert all the players
     * @param firstName name of the player
     * @param lastName lastname of the player
     * @param playerNumber number of the player
     */
    public Player(String firstName, String lastName, IntegerProperty playerNumber, IntegerProperty fouls, IntegerProperty defensiveRebounds, IntegerProperty offensiveRebounds, IntegerProperty steals, IntegerProperty turnOver, IntegerProperty assists, IntegerProperty blocks, IntegerProperty madeFreeThrows, IntegerProperty attemptedFreeThrows, IntegerProperty madeTwoPointers, IntegerProperty attemptedTwoPointers, IntegerProperty madeThreePointers, IntegerProperty attemptedThreePointers, IntegerProperty minutesPlayed) {
        super(firstName, lastName);
        this.playerNumber = playerNumber;
        this.fouls = null;
        this.defensiveRebounds = null;
        this.offensiveRebounds = null;
        this.steals = null;
        this.turnOver = null;
        this.assists = null;
        this.blocks = null;
        this.madeFreeThrows = null;
        this.attemptedFreeThrows = null;
        this.madeTwoPointers = null;
        this.attemptedTwoPointers = null;
        this.madeThreePointers = null;
        this.attemptedThreePointers = null;
        this.minutesPlayed = null;
    }

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

    /**
     * playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber.get();
    }

    public IntegerProperty playerNumberProperty() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber.set(playerNumber);
    }

    /**
     * fouls
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

    /**
     * defensiveRebounds
     */
    public int getDefensiveRebounds() {
        return defensiveRebounds.get();
    }

    public IntegerProperty defensiveReboundsProperty() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds.set(defensiveRebounds);
    }

    /**
     * offensiveRebounds
     */
    public int getOffensiveRebounds() {
        return offensiveRebounds.get();
    }

    public IntegerProperty offensiveReboundsProperty() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds.set(offensiveRebounds);
    }

    /**
     * steals
     */
    public int getSteals() {
        return steals.get();
    }

    public IntegerProperty stealsProperty() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals.set(steals);
    }

    /**
     * turnOver
     */
    public int getTurnOver() {
        return turnOver.get();
    }

    public IntegerProperty turnOverProperty() {
        return turnOver;
    }

    public void setTurnOver(int turnOver) {
        this.turnOver.set(turnOver);
    }

    /**
     * assists
     */
    public int getAssists() {
        return assists.get();
    }

    public IntegerProperty assistsProperty() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists.set(assists);
    }

    /**
     * blocks
     */
    public int getBlocks() {
        return blocks.get();
    }

    public IntegerProperty blocksProperty() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks.set(blocks);
    }

    /**
     * madeFreeThrows
     */
    public int getMadeFreeThrows() {
        return madeFreeThrows.get();
    }

    public IntegerProperty madeFreeThrowsProperty() {
        return madeFreeThrows;
    }

    public void setMadeFreeThrows(int madeFreeThrows) {
        this.madeFreeThrows.set(madeFreeThrows);
    }

    /**
     * attemptedFreeThrows
     */
    public int getAttemptedFreeThrows() {
        return attemptedFreeThrows.get();
    }

    public IntegerProperty attemptedFreeThrowsProperty() {
        return attemptedFreeThrows;
    }

    public void setAttemptedFreeThrows(int attemptedFreeThrows) {
        this.attemptedFreeThrows.set(attemptedFreeThrows);
    }

    /**
     * madeTwoPointers
     */
    public int getMadeTwoPointers() {
        return madeTwoPointers.get();
    }

    public IntegerProperty madeTwoPointersProperty() {
        return madeTwoPointers;
    }

    public void setMadeTwoPointers(int madeTwoPointers) {
        this.madeTwoPointers.set(madeTwoPointers);
    }

    /**
     * attemptedTwoPointers
     */
    public int getAttemptedTwoPointers() {
        return attemptedTwoPointers.get();
    }

    public IntegerProperty attemptedTwoPointersProperty() {
        return attemptedTwoPointers;
    }

    public void setAttemptedTwoPointers(int attemptedTwoPointers) {
        this.attemptedTwoPointers.set(attemptedTwoPointers);
    }

    /**
     * madeThreePointers
     */
    public int getMadeThreePointers() {
        return madeThreePointers.get();
    }

    public IntegerProperty madeThreePointersProperty() {
        return madeThreePointers;
    }

    public void setMadeThreePointers(int madeThreePointers) {
        this.madeThreePointers.set(madeThreePointers);
    }

    /**
     * attemptedThreePointers
     */
    public int getAttemptedThreePointers() {
        return attemptedThreePointers.get();
    }

    public IntegerProperty attemptedThreePointersProperty() {
        return attemptedThreePointers;
    }

    public void setAttemptedThreePointers(int attemptedThreePointers) {
        this.attemptedThreePointers.set(attemptedThreePointers);
    }

    /**
     * getMinutesPlayed
     */
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
