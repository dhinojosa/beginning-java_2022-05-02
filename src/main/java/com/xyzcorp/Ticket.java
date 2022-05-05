package com.xyzcorp;

import java.time.LocalDate;

public record Ticket(String id,
                     LocalDate saleDate,
                     LocalDate redeemedDate,
                     String seatLocation) implements Comparable<Ticket> {
    @Override
    public int compareTo(Ticket o) {
        return this.id.compareTo(o.id);
    }
}
