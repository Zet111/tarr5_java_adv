package oop.controller;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;
import oop.model.enums.UserField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Interfejs -> czyli szablon wymagań dla klasy go implementującej
public interface UserControllerTempl {
    // pole statyczne finalne
    public static final List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("Adam", "Kowalski", "ak@ak.pl", "ak", "123456789", Gender.MAN),
                    new User("Jan", "Nowak", "jmn@ak.pl", "ak", "123456789", Gender.MAN),
                    new User("Anna", "Żółwińska", "jmn@ak.pl", "ak", "123456789", Gender.WOMAN)
            )
    );

    // metoda abstrakcyjna -> metoda nie posiadająca ciała czyli implementacji (realizacji) -> sygnatura metody
    // [typ zwracanej wartości / void] [nazwa_metody] ( [argument-y / bez argumentów] );

    // rejestracja
    public void registerUser();

    // logowanie
    boolean loginUser(String email, String password);

    // wyszukiwanie
    User findUserById(int userId);

    // update password
    void updateUserPassword(int userId, String newPassword);

    // delete user
    void deleteUserById(int userId);

    // add / drop role
    void updateRole(int userId, Set<Role> newRoles);

    // wypisanie wszystkich użytkowników
    List<User> findAllUsers();

    // wypisanie użytkowników posortowanych po argumencie
    List<User> findAllUsersOrderByArg(UserField userField, boolean asc);
}