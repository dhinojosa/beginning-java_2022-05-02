package com.xyzcorp;

public enum BaseballPosition {
    CATCHER("C"),
    SHORTSTOP("SS"),
    FIRST_BASE("FB"),
    SECOND_BASE("SB"),
    THIRD_BASE("TB"),

    PITCHER("P");
    private final String symbol;

    BaseballPosition(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
