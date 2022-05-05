package com.qrscorp.webapp;

import com.xyzcorp.MemoryConferenceRegistrationService;
import com.xyzcorp.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        RegistrationEndPoint registrationEndPoint =
            new RegistrationEndPoint
                (new MemoryConferenceRegistrationService());



    }
}
