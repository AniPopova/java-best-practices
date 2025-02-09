package data.types;


public class StringConcatenation {
    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        showBadPractice();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));
    }

    private static void showBadPractice() {
        /**String is immutable, every time we + new number, we actually create a new String */
        String numericalSequence = "";
        for (int i = 0; i < 10000; i++) {
            numericalSequence += i;
        }
        System.out.println(numericalSequence);
    }

    private static void showGoodPractice() {
        /** Good alternatives are StringBuffer, StringJoiner also */
        StringBuilder numericaSequence = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            numericaSequence.append(i);
        }
        System.out.println(numericaSequence);
    }
}




