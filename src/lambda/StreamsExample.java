package lambda;

import static java.util.Arrays.asList;

public class StreamsExample {

    public static void main(String[] args) {
        asList("A","BB","CCC").stream()
                .filter(s -> s.length() > 1)
                .map(String::length)
                .forEach(System.out::println);



    }
}
