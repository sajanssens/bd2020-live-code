package org.example.unittesting;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {
        if (s.trim().isEmpty()) return ZERO;

        try {
            if (!s.contains(",")) {
                return trimAndParse(s);
            } else {
                int commaPos = s.indexOf(',');

                String first = s.substring(0, commaPos);
                String second = s.substring(commaPos + 1);

                return add(first) + add(second);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Voer een getal in tussen " + Integer.MIN_VALUE + " en " + Integer.MAX_VALUE);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    private int trimAndParse(String input) {
        return Integer.parseInt(input.trim());
    }
}
