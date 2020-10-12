package org.example.h14;

import org.example.h7.Person;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> someInts = Arrays.asList(1, 2, 3, 4);
        Vector<Integer> integers = new Vector<>(someInts);

        for (Integer integer : integers) {
            // System.out.println(integer);
        }

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(5);
        integers1.add(4);
        integers1.add(3);
        integers1.add(2);

        Set<Integer> integerSet = new HashSet<>(integers1);

        for (Integer integer : integerSet) {
            // System.out.println(integer);
        }

        Set<Person> people = new TreeSet<>();

        people.add(new Person("D", 1));
        people.add(new Person("A", 3));
        people.add(new Person("C", 4));
        people.add(new Person("B", 2));

        for (Person person : people) {
            System.out.println(person);
        }

        Map<Integer, Person> personMap = new HashMap<>();
        Person p1 = new Person("B", 1);
        Person p2 = new Person("C", 3);
        Person p3 = new Person("A", 2);

        personMap.put(p1.getAge(), p1);
        personMap.put(p2.getAge(), p2);
        personMap.put(p3.getAge(), p3);

        for (Map.Entry<Integer, Person> row : personMap.entrySet()) {
            Integer key = row.getKey();
            Person value = row.getValue();
            System.out.println(key + " -- " + value);
        }

        Queue<Integer> intRij = new PriorityQueue<>();

        intRij.add(1); //first in, aan de kop van de rij
        intRij.add(2); //second in, tweede in de rij
        intRij.peek(); //returns de kop van de rij, in dit geval 1
        intRij.poll(); //returns de kop van de rij en haalt die ook weg!

        // ----------------------------

        Set<Person> setje = new TreeSet<>();
        setje.add(new Person("A"));
        setje.add(new Person("B"));
        setje.add(new Person("C"));
        setje.add(new Person("D"));

        // from set to map:
        Map<String, Person> stringPersonMap = new HashMap<>();
        for (Person p : setje) {
            stringPersonMap.put(p.getLastName(), p);
        }
        Person p = stringPersonMap.get("E");

        // or:

        Map<String, Person> stringPersonMapAlt =
                setje.stream().collect(toMap(Person::getLastName, person -> person));
        Person q = stringPersonMapAlt.get("E");

    }
}
