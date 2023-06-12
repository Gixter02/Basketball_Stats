package com.example.basketball_stats.classes;

public class OurEvent {
    private String eventType;
    private String whoDidIt;
    private String quarter;
    private double x;
    private double y;

    /**
     * Full constructor
     * @param eventType what
     * @param whoDidIt who
     * @param quarter when
     * @param x where
     * @param y where
     */
    public OurEvent(String eventType, String whoDidIt, String quarter, double x, double y) {
        this.eventType = eventType;
        this.whoDidIt = whoDidIt;
        this.quarter = quarter;
        this.x = x;
        this.y = y;
    }


    /*
     * Getters and setters
     */
    /**
     * eventType
     */
    public String geteventType() {
        return eventType;
    }

    public void seteventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * whoDidIt
     */
    public String getWhoDidIt() {
        return whoDidIt;
    }

    public void setWhoDidIt(String whoDidIt) {
        this.whoDidIt = whoDidIt;
    }

    /**
     * quarter
     */
    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    /**
     * x
     */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    /**
     * y
     */
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "OurEvent{" +
                "eventType='" + eventType + '\'' +
                ", whoDidIt='" + whoDidIt + '\'' +
                ", quarter='" + quarter + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}


