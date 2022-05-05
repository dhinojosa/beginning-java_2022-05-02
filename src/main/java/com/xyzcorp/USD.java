package com.xyzcorp;

public class USD implements Comparable<USD> {
    private int units;

    public USD(int units) {
        this.units = units;
    }

    public int getUnits() {
        return units;
    }


    @Override
    public String toString() {
        return String.format("$%d", this.units);
    }

    @Override
    public int compareTo(USD o) {
        return this.units - o.units;
    }
}
