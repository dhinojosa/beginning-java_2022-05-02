package com.abccorp;

import com.xyzcorp.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Person person = Person.of("Donald", "Bough", LocalDate.of(1972, 2, 20));
        System.out.println(person.getFirstName());

        LocalDate.of(2012, 3, 20);
        List<Person> people0 = new ArrayList<>();
        List<Person> people1 = new LinkedList<>();
    }
}
