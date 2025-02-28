package methods.signatures;

import java.util.ArrayList;
import java.util.List;

public class DesignSample {
    /**
     * Avoid long parameter list, 4 params or less
     * Choose short & informative method names with verbs
     * prefer usage of interfaces over classes in param lists
     * reduce the number of params
     * - split methods
     * - create helper parameter classes
     */
    public static void main(String[] args) {
        System.out.println("--BAD PRACTICE--");
        showBadPractice();

        System.out.println("--GOOD PRACTICE--");
        showGoodPractice();
    }

    private static void showBadPractice() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("Count the desired elements in list: " + elementNumber(new ArrayList<>(numbers), 2, 7, 1, 12));

    }

    private static int elementNumber(ArrayList<Integer> array, int min, int max, int skip, int finish) {
        int counter = 0;
        for (int i = skip; i < finish; i++) {
            if (array.get(i) >= min && array.get(i) <= max) {
                counter++;
            }
        }
        return counter;
    }

    private static void showGoodPractice() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        SearchIndexRange searchRange = new SearchIndexRange(1, 12);
        SearchValueRange valueRange = new SearchValueRange(2, 7);
        System.out.println("Count the desired elements in list: " + countElementsInRange(numbers, searchRange, valueRange));
    }

    private static int countElementsInRange(List<Integer> numbers, SearchIndexRange searchRange, SearchValueRange valueRange) {
        int counter = 0;
        for (int i = searchRange.startIndex(); i < searchRange.finishIndex(); i++) {
            if (numbers.get(i) >= valueRange.minValue && numbers.get(i) <= valueRange.maxValue) {
                counter++;
            }
        }
        return counter;
    }

    record SearchIndexRange(int startIndex, int finishIndex){

    }

    record SearchValueRange(int minValue, int maxValue){

    }
}
