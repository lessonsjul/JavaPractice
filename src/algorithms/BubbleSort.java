package algorithms;

import java.util.Arrays;

/**
 * для каждой пары индексов производится обмен, если элементы расположены не по порядку
 * Худшее время O(n^2)
 * Лучшее время O(n)
 * Среднее время O(n^2)
 * Затраты памяти O(1)
 */

public class BubbleSort {

    public static void sort(int[] target){
        long time = System.currentTimeMillis();

        for(int i = 0; i < target.length - 1; i++){
            int f = 0;
            for(int j = 0; j < target.length - i - 1; j++){
                if(target[j] > target[j + 1]){
                    int tmp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = tmp;
                    f = 1;
                }
            }

            System.out.println(Arrays.toString(target));
            if(f == 0) break; // если не было сделано ни одной перестановки даном цикле
        }

        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
