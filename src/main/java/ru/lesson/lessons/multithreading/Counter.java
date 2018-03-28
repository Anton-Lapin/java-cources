package ru.lesson.lessons.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger amount = new AtomicInteger(0);

    public int increace() {
        amount.incrementAndGet();
        return amount.get();
    }
}
