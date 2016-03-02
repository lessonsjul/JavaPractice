package algorithms;

import java.util.Arrays;

/**
 * для каждой пары индексов производится обмен, если элементы расположены не по порядку
 * если при движении по части массива перестановки не происходят,
 * то эта часть массива уже отсортирована и, следовательно, её можно исключить из рассмотрения
 *
 *  при движении от конца массива к началу минимальный элемент “всплывает” на первую позицию,
 *  а максимальный элемент сдвигается только на одну позицию вправо
 *
 * Худшее время O(n^2)
 * Лучшее время O(n)
 * Среднее время O(n^2)
 * Затраты памяти O(1)
 * Наименьшее число сравнений C = N-1
 */

public class CocktailSort {
    public static void sort(int[] target){
        int left = 0;
        int right = target.length - 1;

        do{
            //сдвиигаем  концу массива тжелые елементы
            for(int i = left; i < right; i++){
                if(target[i] > target[i+1]) {
                    target[i] ^= target[i+1];
                    target[i+1] ^= target[i];
                    target[i] ^= target[i+1];
                }
            }
            right--;//уменьшаем правую границу

            System.out.println(Arrays.toString(target));

            //сдвигаем к началу массива легкие элементы
            for(int i = right; i > left; i--){
                if(target[i]<target[i-1]){
                    target[i] ^= target[i-1];
                    target[i-1] ^= target[i];
                    target[i] ^= target[i-1];
                }
            }
            left++;

            System.out.println(Arrays.toString(target));
        }
        while(left <= right);

    }
}
