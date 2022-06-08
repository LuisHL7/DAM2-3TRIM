package com.company.activity3_7;

import java.io.Serializable;

public class Numbers implements Serializable {
    private int number;
    private long square;
    private long cube;

    public Numbers() {
    }

    public Numbers(int number, long square, long cube) {
        this.number = number;
        this.square = square;
        this.cube = cube;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getSquare() {
        return square;
    }

    public void setSquare(long square) {
        this.square = square;
    }

    public long getCube() {
        return cube;
    }

    public void setCube(long cube) {
        this.cube = cube;
    }
}
