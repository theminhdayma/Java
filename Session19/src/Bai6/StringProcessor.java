package Bai6;

import java.util.List;

interface StringProcessor {
    abstract String processString(String input);

    default void printList(List<String> list) {
        list.forEach(System.out::println);
    }
}
