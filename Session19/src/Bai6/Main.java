package Bai6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "lambda", "stream", "functional");

        StringProcessor processor = (input) -> input.toUpperCase() + " - TECHNICAL";

        List<String> processedStrings = new ArrayList<>();
        for (String str : strings) {
            processedStrings.add(processor.processString(str));
        }

        processor.printList(processedStrings);
    }
}
