package Bai7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -2, 10, 0, -7, 3);

        ListProcessor processor = new ListProcessorImpl();

        ListProcessor.printList(list);
        if (processor.containsNegative(list)) {
            System.out.println("Danh sách chứa số âm");
        } else {
            System.out.println("Danh sách không chứa số âm");
        }
    }
}

