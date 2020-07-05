package collections;

import java.lang.reflect.Array;
import java.util.*;

public class JavaCollectionsExample {
    // pola globalne
    private List<String> names = new ArrayList<>(Arrays.asList("Jan", "Ala", "Ola", "Ela", "Ala"));

    private Set<String> roles1 = new HashSet<>(Arrays.asList("admin", "user"));
    private Set<String> roles2 = new HashSet<>(Arrays.asList("user", "viewer", "moderator"));

    private Map<Integer, String> decimalToRoman = new HashMap<>();
    private Map<String, Integer> romanToDecimal = new HashMap<>();

    private Deque<String> messages = new ArrayDeque<>();

    public void arrayOperations() {
        try {
            // utworzenie tablicy 10-cio elementowej
            String[] names = new String[10];
            int[] numbers = {1, 2, 3, 4};
            System.out.println("Tablica nazw:");
            Arrays.stream(names)    // zamiana tablicy na stream
                    .forEach(s -> System.out.println(s));     //dla każdego elementu wykonaj predykat (CTRL + space)

            System.out.println("\\nTablica liczb:");
            Arrays.stream(numbers).forEach(n -> System.out.println(n)); //ta linia
            Arrays.stream(numbers).forEach(System.out::println);        //i ta robią to samo (inny zapis)

            System.out.println("Modyfikacja wartości na indeksie");
            names[5] = "Anna";
            names[names.length - 1] = "Adam";
            names[100] = "Jan"; //ArrayIndexOutOfBoundsException
            Arrays.stream(names).forEach(s -> System.out.println(s));
        } catch(ArrayIndexOutOfBoundsException e) { // obsługa wyjątku
            System.out.println("Błąd indeksowania tablicy. (" + e.getLocalizedMessage() + ")");
        }
        System.out.println("\nPoza try-catch");
    }

    public void listOperations() {
        // utworzenie listy
        List<String> names = new ArrayList<>();
        // utworzenie listy zainicjowanej wartościami
        List<Double> params = new ArrayList<>(Arrays.asList(1.2, 1.44, 1.11, 4.));  //kropka po 4 potrzebna
        System.out.println(names);
        System.out.println(params);
    }

    public boolean findElement(List<String> names, String name) {
        return names.contains(name);
    }

    public void removeElement(String name) {
        System.out.println(names);
        names.remove(name);     //usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }

    public void removeAllTeSameElement(String name) {
        System.out.println(names);
        names.removeAll(Arrays.asList(name));     //usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }

    // zmień pierwszy i ostatni element na Adam w liście names
    public void updateFirstAndLastElement(String name) {
        names.set(0, name);
        names.set(names.size() - 1, name);
    }
    // wypisz wszystkie elementy znajdujące się na parzystych indeksach listy names
    public void getAllElementsWithOddIndex() {
        for (int i = 0; i < names.size(); i+=2) {
            System.out.print(names.get(i) + " ");
        }
    }

    // jakie mamy wszystkie role w serwisie www
    public Set<String> getAllRoles() {
        // utworzenie podręcznego zbioru z widocznością tylko w obrębie metody
        Set<String> allRoles = new HashSet<>(); // można zmienić na TreeSet to będą posortowane
        allRoles.addAll(roles1);
        allRoles.addAll(roles2);
        return allRoles;
    }

    // jakie role się powtarzają (czyli część wspólna zbiorów
    public Set<String> getNonUniqueRoles() {
        Set<String> nonUniqueRoles = new TreeSet<>();
        nonUniqueRoles.addAll(roles1);
        nonUniqueRoles.retainAll(roles2);
        return nonUniqueRoles;
    }

    // wypisz wszystkie unikatowe elementy obu zbiorów
    public Set<String> getUniqueRoles() {
        Set<String> uniqueRoles = getAllRoles();
        uniqueRoles.removeAll(getNonUniqueRoles());
        return uniqueRoles;
    }

    public void generateValuesIntoMap() {
        decimalToRoman.put(0, "0");
        decimalToRoman.put(1, "I");
        decimalToRoman.put(2, "II");
        decimalToRoman.put(3, "III");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(5, "V");
        decimalToRoman.put(6, "VI");
        decimalToRoman.put(7, "VII");
        decimalToRoman.put(8, "VIII");
        decimalToRoman.put(9, "IX");
        decimalToRoman.put(10, "X");
        System.out.println(decimalToRoman);
    }
    public void generateRomanToDecimal() {
        for (Integer key : decimalToRoman.keySet()) {
            romanToDecimal.put(decimalToRoman.get(key), key);
        }
        System.out.println(romanToDecimal);
    }

    public void sendMessage(String message) {
        messages.addLast(message);
        System.out.println(messages);
    }

    public void receiveMessage() {
        try {
            while (!messages.isEmpty()) {
                Thread.currentThread().sleep(2000); // uśpienie programu na 2000 ms
                System.out.println("Odebrano wiadomość: " + messages.removeFirst());
                System.out.println("Pozostałe wiadomości: " + messages);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void comunicationService() {

    }

    public static void main(String[] args) {
        JavaCollectionsExample ex = new JavaCollectionsExample();
        ex.arrayOperations();
        ex.listOperations();
        System.out.println("Wynik: " + ex.findElement(new ArrayList<>(Arrays.asList("Jan", "Ala", "Ola", "Ela", "Ala")), "Ala"));
        //ex.removeElement("Ala");
        //ex.removeAllTeSameElement("Ala");
        ex.updateFirstAndLastElement("Kunegunda");
        ex.getAllElementsWithOddIndex();
        System.out.println("\nAll roles: " + ex.getAllRoles());
        System.out.println("\nNon-unique roles: " + ex.getNonUniqueRoles());
        System.out.println("\nUnique roles: " + ex.getUniqueRoles());
        ex.generateValuesIntoMap();
        ex.generateRomanToDecimal();

        ex.sendMessage("A");
        ex.sendMessage("B");
        ex.sendMessage("C");

        ex.receiveMessage();
    }
}