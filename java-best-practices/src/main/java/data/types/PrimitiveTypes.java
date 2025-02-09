package data.types;

public class PrimitiveTypes {

    //static Integer internalNumber; primitive types have initial value, rather than wrapper classes
    static int internalNumber;

    public static void main(String[] args) {
        showBadPracticeNulls();
        System.out.println("-- BAD PRACTICE --");
        long startTime = System.currentTimeMillis();
        showBadPracticePerfomance();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPracticePerformance();
        System.out.println("Time spent in ms: " + (System.currentTimeMillis() - startTime));

    }

    private static void showBadPracticeNulls() {
        if (internalNumber == 108) {
            System.out.println("The internal number is 108!");
        }
    }

    private static void showBadPracticePerfomance() {
        Integer sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
            /** This is much slower because everytime we try add a number we are unboxig
             * the wrapper class to make it primitive again and that cost time*/
        }
        System.out.println("Final number: " + sum);
    }

    private static void showGoodPracticePerformance() {
        int sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += i;
        }
        System.out.println("Final number: " + sum);
    }
}

/**Null objects of reference types throw NullPointerException when auto-unboxing
 * Reference types are usually slower,
 * but in collections for example you can use only reference types*/