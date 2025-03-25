package Bai8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListProcessor processor = new ListProcessorImpl();

        List<Integer> list = Arrays.asList(6, 8, 10, 16, 6, 2);
        ListProcessor.printList(list);
        System.out.println("Tổng các số lẻ: " + processor.sumOddNumbers(list));
        processor.checkOdd(list);
    }
}
