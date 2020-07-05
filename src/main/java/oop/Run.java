package oop;

import oop.model.User;
import oop.model.enums.Gender;

public class Run {
    public static void main(String[] args) {
        User u1 = new User("Adam", "Kowalski", "ak@ak.pl", "ak", "123456789", Gender.MAN);
        User u2 = new User("Jan", "Nowak", "jmn@ak.pl", "ak", "123456789", Gender.MAN);
        User u3 = new User("Anna", "Żółwińska", "jmn@ak.pl", "ak", "123456789", Gender.WOMAN);
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(u3.toString());
    }
}