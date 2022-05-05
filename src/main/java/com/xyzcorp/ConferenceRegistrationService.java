package com.xyzcorp;

import java.util.List;

public interface ConferenceRegistrationService {
    void registerPerson(Person person);
    void registerPeople(List<Person> people);
}
