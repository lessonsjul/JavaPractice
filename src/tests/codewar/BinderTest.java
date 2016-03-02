package codewar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BinderTest {
    @Test
    public void testBinding() throws Exception {
        Binder binder = new Binder();
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(binder.bind(list, i -> Arrays.asList(i)), Arrays.asList(1, 2, 3));

        list = Arrays.asList(7, 8, 9);
        assertEquals(binder.bind(list, i -> Arrays.asList(Arrays.asList(i))),
                Arrays.asList(Arrays.asList(7), Arrays.asList(8), Arrays.asList(9)));

        list = Arrays.asList(3, 4, 5);
        assertEquals(binder.bind(list, i -> Arrays.asList(Arrays.asList(i, (int) i * -1))),
                Arrays.asList(Arrays.asList(3, -3), Arrays.asList(4, -4), Arrays.asList(5, -5)));

        list = Arrays.asList(5, 6, 7);
        assertEquals(binder.bind(list, i -> Arrays.asList(i.toString())), Arrays.asList("5", "6", "7"));
    }
}