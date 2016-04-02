package algorithms;

import java.util.Arrays;

public class MergeSort {

    /**
     * @param target массив для сортировки
     * @param p индекс первого элемента подмассива
     * @param r индекс последнего элемента подмассива
     * */
    public static void prometeusSort(int[] target, int p, int r){
       if(p < r){

           int q = (p+r)/2;
           prometeusSort(target, p, q);
           prometeusSort(target, q+1, r);
           merge(target, p, q, r);
       }
    }

    private static void merge(int[] target, int p, int q, int r) {
       int n1 = q-p+1;
        int n2= r-q;

        int[] L = new int[n1];
        for(int i = 0; i < n1; i++)
            L[i] = target[p+i];
        int[] R = new int[n2];
        for(int j = 0; j < n2; j++)
            R[j] = target[q+j+1];

        int a = 0;
        int b = 0;
        for(int k = p; k <= r; k++){
            if(b >= n2 || a < n1 && L[a] <= R[b]){
                target[k] = L[a];
                a = a+1;
            }else{
                target[k] = R[b];
                b = b+1;
            }
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{2,4,5,7,1,2,3,6};
        System.out.println(Arrays.toString(t));
        prometeusSort(t,0,t.length-1);
        System.out.println(Arrays.toString(t));
    }
}
