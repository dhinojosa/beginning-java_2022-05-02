package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testEquality() {
        Person p1 = Person.of("Deepa", "Esturi", LocalDate.of(1972, 2, 20));
        Person p2 = Person.of("Deepa", "Esturi", LocalDate.of(1972, 2, 20));

        assertEquals(p1, p2);
    }

    @Test
    public void testEqualityWithANumber() {
        Person p1 = Person.of("Deepa", "Esturi", LocalDate.of(1972, 2, 20));
        assertNotEquals(30, p1);
    }

    @Test
    public void testEqualityWithASlightlyDifferentSpellingForLastName() {
        Person p1 = Person.of("Deepa", "Esturii", LocalDate.of(1972, 2, 20));
        Person p2 = Person.of("Deepa", "Esturi", LocalDate.of(1972, 2, 20));
        assertNotEquals(p1, p2);
    }

    @Test
    public void testToString() {
        Person p1 = Person.of("Deepa", "Esturi", LocalDate.of(1972, 2, 20));
        assertEquals("Person[firstName='Deepa', lastName='Esturi']",
            p1.toString());
    }

    @Test
    public void testPersonAge() {
        Person p1 = Person.of("Daniel", "Hinojosa", LocalDate.of(1972, 2, 20));
        assertEquals(50, p1.getAge());
    }

    @Test
    public void testPersonSet() {
        Set<Person> people = new HashSet<>();
        Person e0 = new Person("Pramod", "Pai");


        people.add(e0);

        Person e2 = new Person("Deepa", "Esturi");
        people.add(e2);

        Person e1 = new Person("Pramod", "Pai");

        System.out.println(e0.hashCode());
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());


        people.add(e1);

        Person e3 = new Person("Daniel", "Hinojosa");
        people.add(e3);
        e3.setFirstName("Pramod");
        e3.setLastName("Pai");
        System.out.println(people);
    }

    @Test
    public void testMap() {
        Map<BaseballPosition, Person> myBaseballTeam = new TreeMap<>();
        Person chris = new Person("Chris", "Wang");
        myBaseballTeam.put(BaseballPosition.CATCHER, chris);
        myBaseballTeam.put(BaseballPosition.FIRST_BASE, new Person("Augusto",
            "Wloch"));
        myBaseballTeam.put(BaseballPosition.SECOND_BASE, new Person(
            "Ankanksha", "Lohari"));
        myBaseballTeam.put(BaseballPosition.SHORTSTOP, new Person("Kim",
            "Schaefges"));
        myBaseballTeam.put(BaseballPosition.THIRD_BASE, new Person("Donald",
            "Bough"));

        Person person = myBaseballTeam.get(BaseballPosition.CATCHER);
        System.out.println(person);

        Person person2 = myBaseballTeam.get(BaseballPosition.THIRD_BASE);
        System.out.println(person2);

        Optional<Person> optionalPerson1 =
            Optional.ofNullable(myBaseballTeam.get(BaseballPosition.PITCHER));

        Person person3 = optionalPerson1.orElse(new Person("Marlon", "Rando"));

        System.out.println(person3);

        Optional<Person> optionalPerson2 =
            Optional.ofNullable(myBaseballTeam.get(BaseballPosition.SHORTSTOP));

        Person person4 = optionalPerson2.orElse(new Person("Marlon", "Rando"));

        System.out.println(person4);

        //-----

        String result =
            Optional
                .ofNullable(myBaseballTeam.get(BaseballPosition.PITCHER))
                .map(Person::getLastName)
                .orElse("Rando");

        System.out.println(result);
    }

    @Test
    public void testMapFunction() {
        Optional<Integer> o1 = Optional.of(40);
        Optional<String> result = o1.map(i -> "number is " + i);
        System.out.println(result);
    }

    @Test
    public void testFlatMapSuccess() {
        Optional<Integer> o1 = Optional.of(40);
        Optional<Integer> o2 = Optional.of(20);
        Optional<Integer> result = o1.flatMap(i -> o2.map(j -> i + j));
        System.out.println(result);
    }



    @Test
    public void testFlatMapSuccess2() {
        Optional<Integer> o1 = Optional.of(40);
        Optional<Integer> o2 = Optional.of(20);
        Optional<Integer> o3 = Optional.empty();
        Optional<Integer> o4 = Optional.of(30);
        Integer result =
            o1.flatMap(i ->
                o2.flatMap(j ->
                    o3.flatMap(k ->
                        o4.map(m -> i + j + k + m))))
              .orElse(-1);

        System.out.println(result);
    }


    @Test
    public void testFlatMapFailure() {
        Optional<Integer> o1 = Optional.of(40);
        Optional<Integer> o2 = Optional.empty();
        Optional<Integer> result = o1.flatMap(i -> o2.map(j -> i + j));
        System.out.println(result);
    }

    public void process(Iterable<String> iterable) {
        for (String s : iterable) {
            System.out.println(s + "!");
        }
        System.out.println("Done");
    }

    @Test
    public void testProcessing() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Green");
        list.add("Blue");
        process(list);
    }

    @Test
    public void testCollectionsSortOfPerson() {
        Person p1 = new Person("Roy", "Simmons");
        Person p2 = new Person("Carla", "Rodriguez");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
    }


}
