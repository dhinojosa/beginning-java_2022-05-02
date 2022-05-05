package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class TicketTest {
    @Test
    public void testCompareBySeat() {
        //Comparator<Ticket> comparator =

        Ticket t1 = new Ticket("51",
            LocalDate.of(2022, 5, 1),
            LocalDate.of(2022, 5, 4),
            "S3");

        Ticket t2 = new Ticket("55",
            LocalDate.of(2022, 4, 30),
            LocalDate.of(2022, 5, 4),
            "M4");

        System.out.println(t1.compareTo(t2));

//        TicketComparatorBySeat ticketComparatorBySeat =
//            new TicketComparatorBySeat();

        //anonymous instantiation
        Comparator<Ticket> ticketComparatorBySeat =
            Comparator.comparing(Ticket::seatLocation);

        Comparator<Ticket> ticketComparatorByRedeemedDate =
            Comparator.comparing(Ticket::redeemedDate);

        System.out.println(ticketComparatorBySeat.compare(t1, t2));

        TreeSet<Ticket> treeSet = new TreeSet<>(ticketComparatorByRedeemedDate);

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(t1);
        ticketList.add(t2);
        Collections.sort(ticketList, ticketComparatorBySeat);
        System.out.println(ticketList);
    }

    @Test
    public void testTicketIntersection() {
        HashSet<Ticket> tickets = new HashSet<>();
        HashSet<Ticket> redeemedTickets = new HashSet<>();
        tickets.retainAll(redeemedTickets);
        tickets.removeAll(redeemedTickets);
    }
}
