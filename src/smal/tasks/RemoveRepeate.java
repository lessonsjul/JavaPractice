package smal.tasks;

import java.util.*;

public class RemoveRepeate {

    public static void main(String[] args){
        String[] strings = new String[]{"Hello", "Hello", "Vasiliy", "Vasiliy", "Hello"};
        int[] number = new int[1000];

        Random random = new Random(100);
        for(int i = 0; i < 1000; i++){
            number[i] = random.nextInt();
        }

//        strings = removeRepeatedString(strings);

        System.out.println(Arrays.toString(removeRepeatedString(strings)));
        System.out.println(Arrays.toString(removeRepeate(number)));
    }

    public static String[] removeRepeatedString(String[] target){
        if(target == null || target.length == 0) return target;

        Set<String> el = new HashSet<>(Arrays.asList(target));

        String[] result = new String[el.size()];
        result = el.toArray(result);


        return result;
    }

    public static int[] removeRepeate(int[] target){
        if(target == null || target.length == 0){return target;}

        ArrayList<Integer> elements = new ArrayList<>();
        for(int elem: target) {
            if(!elements.contains(elem))
                elements.add(elem);
        }

        if(elements.size() == target.length)
            return target;
        else{
            int[] result = new int[elements.size()];
            for(int i = 0; i < elements.size(); i++){
                result[i] = elements.get(i);
            }

            return result;
        }
    }

}
