package algorithms;

import java.util.Arrays;

public class InvertionCount {
    private static int count = 0;

    public static void main(String[] args) {
        int[] t = new int[]{4,2,5,1,3};
        countInv(t);
        int inv = count;
        System.out.println(inv);
    }

    /**
     * Определяем количествоинверсий в массиве
     * @param target массив, в котором хотим найти инверсии*/
    public static int countInversion(int[] target){
        count = 0;
        countInv(target);
        return count;
    }

    private static int[] countInv(int[] target){
        if(target.length == 1) return target;

        int q = target.length / 2;
        int[] left = Arrays.copyOfRange(target, 0, q);
        int[] right = Arrays.copyOfRange(target, q, target.length);

        left = countInv(left);
        right = countInv(right);
        target = countSplitInv(target, left, right);

        return target;
    }

    private static int[] countSplitInv(int[] a, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int c = 0;
        for(int k = 0; k < a.length; k++){
            if ( j >= right.length || i < left.length && left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
                c = c + (left.length - i);
            }
        }
        count += c;
        return a;
    }
}
