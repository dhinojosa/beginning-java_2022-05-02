package com.salesforce;

import com.xyzcorp.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    @Test
    public void testCreateBoxInteger() {
        Box<Integer> bi = new Box<Integer>(40);
        assertEquals(40, (int) bi.item());
    }

    @Test
    public void testCreateBoxString() {
        Box<String> bi = new Box<String>("Hello");
        assertEquals("Hello", bi.item());
    }

    @Test
    public void testCreateBoxPerson() {
        Box<Person> bi = new Box<>
            (new Person("Justin", "Bieber"));
        assertEquals("Hello", bi.item());
    }
}
