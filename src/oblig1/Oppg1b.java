package oblig1;
import java.util.function.BiFunction;

public class Oppg1b {
    public static void main(String[] args) {
        System.out.println(beregn(12, 13, (x,y) -> x + y));
        System.out.println(beregn(-5, 3, (x,y) -> Math.max(x,y)));
        System.out.println(beregn(54, 45, (x,y) -> Math.abs(x-y)));

    }

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> f) {
        return f.apply(a, b);
    }
}
