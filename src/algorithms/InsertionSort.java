package algorithms;

import java.util.Arrays;

/** Insertion sort
 * compare first two elements, put in proper order
 * compare first three elements, put in proper order
 *
 * Best case: data already in order
 * n-1 comparison, 2(n-1) moves
 *
 * Worst case: data in reverse order
 * i comparison in each iteration, n-1 iteration, n-2 iteration ..., n(n-1)/2 = O(n^2)
 * and moves: temps is loaded/unloaded 2(n-1) times, i moves in iteration i, ..., (n^2 +3n-4)/2 = O(n^2)
 *
 * Avarage case: data in random order
 */

public class InsertionSort {
    public static void sort(int[] target){
        int temp;
        for(int i = 0; i < target.length; i++){
           temp = target[i];
            for(int j = i; j > 0 && temp < target[j - 1]; j--){
                target[j] = target[j-1];
                target[j-1] = temp;
            }
            System.out.println(Arrays.toString(target));
        }
    }
}
