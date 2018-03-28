package ru.lesson.lessons.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void hashSet() {
        HashSet<User> users = new HashSet<User>();
        users.add(new User("a","1", "b"));
        users.add(new User("b", "2", "c"));
        users.add(new User("a","1", "b"));
        assertEquals(3, users.size());
    }

    @Test
    public void hashMap() {
        HashMap<User, User> userHashMap = new HashMap<User, User>();
    }
}