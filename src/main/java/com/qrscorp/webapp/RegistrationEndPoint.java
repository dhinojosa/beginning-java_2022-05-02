package com.qrscorp.webapp;

import com.xyzcorp.ConferenceRegistrationService;
import com.xyzcorp.Person;

public class RegistrationEndPoint {
    private ConferenceRegistrationService
        conferenceRegistrationService;

    public RegistrationEndPoint
        (ConferenceRegistrationService conferenceRegistrationService) {
        this.conferenceRegistrationService = conferenceRegistrationService;
    }

    //@Post
    public void postRegistrant(String data) {
        Person person = convertJSONStringIntroPerson(data);
        conferenceRegistrationService.registerPerson(person);
    }

    private Person convertJSONStringIntroPerson(String data) {
        return null;
    }
}
