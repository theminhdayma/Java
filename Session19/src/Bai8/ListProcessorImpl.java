package Bai8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListProcessorImpl implements ListProcessor {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        return list.stream().filter(num -> num % 2 != 0).mapToInt(Integer::intValue).sum();
    }
}