package com.example.basketball_stats.classes;

import javafx.beans.property.IntegerProperty;

public class Player extends Person {
    private Integer playerNumber;
    private Integer fouls;
    private Integer defensiveRebounds;
    private Integer offensiveRebounds;
    private Integer steals;
    private Integer turnOver;
    private Integer assists;
    private Integer blocks;
    private Integer madeFreeThrows;
    private Integer attemptedFreeThrows;
    private Integer madeTwoPointers;
    private Integer attemptedTwoPointers;
    private Integer madeThreePointers;
    private Integer attemptedThreePointers;
    private Integer minutesPlayed;

    /**
     * This will be the most used constructor, as it will be called to insert all the players
     * @param firstName name of the player
     * @param lastName lastname of the player
     * @param playerNumber number of the player
     */
    public Player(String firstName, String lastName, Integer playerNumber, Integer fouls, Integer defensiveRebounds, Integer offensiveRebounds, Integer steals, Integer turnOver, Integer assists, Integer blocks, Integer madeFreeThrows, Integer attemptedFreeThrows, Integer madeTwoPointers, Integer attemptedTwoPointers, Integer madeThreePointers, Integer attemptedThreePointers, Integer minutesPlayed) {
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
    public Player(String firstName, String lastName, Integer fouls, Integer defensiveRebounds, Integer offensiveRebounds, Integer steals, Integer turnOver, Integer assists, Integer blocks, Integer madeFreeThrows, Integer attemptedFreeThrows, Integer madeTwoPointers, Integer attemptedTwoPointers, Integer madeThreePointers, Integer attemptedThreePointers, Integer minutesPlayed) {
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



    /*
     * Getters and setters
     */

    /**
     * @return playerNumber
     */
    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * @return fouls
     */
    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    /**
     * @return defensiveRebounds
     */
    public Integer getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(Integer defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    /**
     * @return offensiveRebounds
     */
    public Integer getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(Integer offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    /**
     * @return steals
     */
    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    /**
     * @return turnOver
     */
    public Integer getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(Integer turnOver) {
        this.turnOver = turnOver;
    }

    /**
     * @return assists
     */
    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    /**
     * @return blocks
     */
    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    /**
     * @return madeFreeThrows
     */
    public Integer getMadeFreeThrows() {
        return madeFreeThrows;
    }

    public void setMadeFreeThrows(Integer madeFreeThrows) {
        this.madeFreeThrows = madeFreeThrows;
    }

    /**
     * @return attemptedFreeThrows
     */
    public Integer getAttemptedFreeThrows() {
        return attemptedFreeThrows;
    }

    public void setAttemptedFreeThrows(Integer attemptedFreeThrows) {
        this.attemptedFreeThrows = attemptedFreeThrows;
    }

    /**
     * @return madeTwoPointers
     */
    public Integer getMadeTwoPointers() {
        return madeTwoPointers;
    }

    public void setMadeTwoPointers(Integer madeTwoPointers) {
        this.madeTwoPointers = madeTwoPointers;
    }

    /**
     * @return attemptedTwoPointers
     */
    public Integer getAttemptedTwoPointers() {
        return attemptedTwoPointers;
    }

    public void setAttemptedTwoPointers(Integer attemptedTwoPointers) {
        this.attemptedTwoPointers = attemptedTwoPointers;
    }

    /**
     * @return madeThreePointers
     */
    public Integer getMadeThreePointers() {
        return madeThreePointers;
    }

    public void setMadeThreePointers(Integer madeThreePointers) {
        this.madeThreePointers = madeThreePointers;
    }

    /**
     * @return attemptedThreePointers
     */
    public Integer getAttemptedThreePointers() {
        return attemptedThreePointers;
    }

    public void setAttemptedThreePointers(Integer attemptedThreePointers) {
        this.attemptedThreePointers = attemptedThreePointers;
    }

    /**
     * @return minutesPlayed
     */
    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }
}
