package com.xyzcorp;

import java.util.Comparator;

public class TicketComparatorBySeat implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.seatLocation().compareTo(o2.seatLocation());
    }
}
