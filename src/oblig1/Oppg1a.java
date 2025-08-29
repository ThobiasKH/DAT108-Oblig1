package oblig1;

import java.util.*;

public class Oppg1a {
    public static void main(String[] args) {
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        Collections.sort(listen, (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));

        listen.forEach(System.out::println);
    }
}
