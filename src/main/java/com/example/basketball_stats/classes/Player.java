package com.example.basketball_stats.classes;

import javafx.beans.property.IntegerProperty;

import java.util.Objects;


public class Player {
    private String firstName;
    private String lastName;
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
     * Most used constructor
     */
    public Player(String firstName, String lastName, Integer playerNumber, Integer fouls, Integer defensiveRebounds, Integer offensiveRebounds, Integer steals, Integer turnOver, Integer assists, Integer blocks, Integer madeFreeThrows, Integer attemptedFreeThrows, Integer madeTwoPointers, Integer attemptedTwoPointers, Integer madeThreePointers, Integer attemptedThreePointers, Integer minutesPlayed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNumber = playerNumber;
        this.fouls = 0;
        this.defensiveRebounds = 0;
        this.offensiveRebounds = 0;
        this.steals = 0;
        this.turnOver = 0;
        this.assists = 0;
        this.blocks = 0;
        this.madeFreeThrows = 0;
        this.attemptedFreeThrows = 0;
        this.madeTwoPointers = 0;
        this.attemptedTwoPointers = 0;
        this.madeThreePointers = 0;
        this.attemptedThreePointers = 0;
        this.minutesPlayed = 0;
    }

    public Player(String firstName, String lastName, Integer playerNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNumber = playerNumber;
        this.fouls = 0;
        this.defensiveRebounds = 0;
        this.offensiveRebounds = 0;
        this.steals = 0;
        this.turnOver = 0;
        this.assists = 0;
        this.blocks = 0;
        this.madeFreeThrows = 0;
        this.attemptedFreeThrows = 0;
        this.madeTwoPointers = 0;
        this.attemptedTwoPointers = 0;
        this.madeThreePointers = 0;
        this.attemptedThreePointers = 0;
        this.minutesPlayed = 0;
    }
    /*
     * Getters and setters
     */

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerNumber.equals(player.playerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNumber);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", playerNumber=" + playerNumber +
                ", fouls=" + fouls +
                ", defensiveRebounds=" + defensiveRebounds +
                ", offensiveRebounds=" + offensiveRebounds +
                ", steals=" + steals +
                ", turnOver=" + turnOver +
                ", assists=" + assists +
                ", blocks=" + blocks +
                ", madeFreeThrows=" + madeFreeThrows +
                ", attemptedFreeThrows=" + attemptedFreeThrows +
                ", madeTwoPointers=" + madeTwoPointers +
                ", attemptedTwoPointers=" + attemptedTwoPointers +
                ", madeThreePointers=" + madeThreePointers +
                ", attemptedThreePointers=" + attemptedThreePointers +
                ", minutesPlayed=" + minutesPlayed +
                '}';
    }
}
