package org.example.h14;

import org.example.h7.Person;

import java.util.*;

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
        Person p = new Person("B", 1);
        Person p2 = new Person("C", 3);
        Person p3 = new Person("A", 2);

        personMap.put(p.getAge(), p);
        personMap.put(p2.getAge(), p2);
        personMap.put(p3.getAge(), p3);

        for (Map.Entry<Integer, Person> row : personMap.entrySet()) {
            Integer key = row.getKey();
            Person value = row.getValue();
            System.out.println(key + " -- " + value);
        }

    }
}
