package Bai7;

import java.util.List;

interface ListProcessor {
    abstract boolean containsNegative(List<Integer> list);
    static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
