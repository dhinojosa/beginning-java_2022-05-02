package com.salesforce;

public class Box<E> {
    private final E item;

    public Box(E item) {
        this.item = item;
    }

    public E item() {
        return item;
    }
}
