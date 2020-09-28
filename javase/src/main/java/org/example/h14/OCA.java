package org.example.h14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OCA {

    public int question1() {
        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        int firstElmnt = elements.get(1);

        return firstElmnt;
    }

    public String question2(int cardVal) {
        // Line n1

        switch (cardVal) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return "Hit";
            // break;
            case 9:
            case 10:
            case 11:
                return "Double";
            // break;
            case 15:
            case 16:
                return "Surrender";
            // break;
            default:
                return "Stand";
        }

    }

    public void question5() {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine(); // Pen
        String s2 = scanner.nextLine(); // Pencil
        String s3 = scanner.nextLine(); // Box

        List<String> items = new ArrayList<>();
        items.add(s1);
        items.add(s2);
        items.add(s3);

        for (String i : items) {
            if (i.indexOf("P") == 0) {
                continue;
            } else {
                System.out.println(i + " ");
            }
        }
        System.out.println();
    }

    public void question7() {
        int x = 10;
        int y = 2;
        try {
            for (int z = 2; z >= 0; z--) {
                int ans = x / z;
                System.out.print(ans + " ");
            }
        } catch (ArithmeticException e1) {
            System.out.println("E2");
        } catch (Exception e1) {
            System.out.println("E1");
        }
    }

    public void question8() {
        StringBuilder s1 = new StringBuilder("Java");
        String s2 = "Love";
        s1.append(s2);
        s1.substring(4);
        int foundAt = s1.indexOf(s2);
        System.out.println(foundAt);
    }

}
