package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsDemo {
    public static void main(String[] args) {

        List<Integer> getallen = Arrays.asList(10, 9, 1, 1, 2, 3, 4, 5, 5, 5, 5);

        List<Integer> oneven = new ArrayList<>();
        for (Integer integer : getallen) {
            if (integer % 2 != 0) {
                oneven.add(integer);
            }
        }

        System.out.println(oneven);

        List<Integer> collect = getallen.stream() // creeer lopende band
                .distinct()
                .filter(g -> g % 2 != 0) // meerdere intermediate operations
                .map(g -> g * 2)
                .sorted()   // int op.
                .flatMap(g -> Stream.of(g, g))
                .collect(toList());// één terminal operation

        System.out.println(collect);

    }
}
