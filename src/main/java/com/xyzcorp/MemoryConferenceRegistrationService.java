package com.xyzcorp;

import java.util.List;

public class MemoryConferenceRegistrationService
    implements ConferenceRegistrationService{


    private List<Person> people;

    @Override
    public void registerPerson(Person person) {
        people.add(person);
    }

    @Override
    public void registerPeople(List<Person> people) {
       this.people.addAll(people);
    }
}
