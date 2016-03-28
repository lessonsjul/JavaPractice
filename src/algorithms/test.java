package algorithms;

public class test {

    public test(){
        x = 5;
        y = 6;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,5,8,9,1,0,3,7};
//        BubbleSort.sort(arr);
//        InsertionSort.sort(arr);
        CocktailSort.sort(arr);
    }

    int x;
    int y;
}
