package Bai8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface ListProcessor {
    abstract int sumOddNumbers(List<Integer> list);
    static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
    default void checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        List<Integer> oddNumbers = list.stream().filter(isOdd).collect(Collectors.toList());

        if (oddNumbers.isEmpty()) {
            System.out.println("Không có phần tử lẻ");
        } else {
            System.out.println("Các phần tử lẻ: " + oddNumbers);
        }
    }
}
