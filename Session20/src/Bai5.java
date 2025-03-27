import java.util.List;
import java.util.Optional;

public class Bai5 {
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        List<List<Integer>> testLists = List.of(normalList, singleElementList, allSameList);

        for (List<Integer> list : testLists) {
            Optional<Integer> secondLargest = findSecondLargest(list);
            System.out.println("Danh sách: " + list);
            secondLargest.ifPresentOrElse(
                    value -> System.out.println("Số lớn thứ hai: " + value),
                    () -> System.out.println("Không tìm thấy số lớn thứ hai")
            );
            System.out.println("---------------------");
        }
    }
}
