package codewar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Binder<T, I> {

    public static void main(String[] args) {
        Binder binder = new Binder();
        List<Integer> list = Arrays.asList(1, 2, 3);
        binder.bind(list, i -> Arrays.asList(i));
    }


    public List<I> bind(List<T> list, Function<T, List<I>> func) {
        //TODO
        return null;
    }
}