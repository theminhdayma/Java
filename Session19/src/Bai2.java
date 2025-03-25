import java.util.function.Function;

public class Bai2 {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> (x * x) + (3 * x) + 2;

        System.out.println("F(1) = " + f.apply(1));
        System.out.println("F(2) = " + f.apply(2));
        System.out.println("F(3) = " + f.apply(3));
    }
}
