package lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Examples {


    // equal expressions
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    };


    Comparator<String> comparator1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

    Comparator<String> comparator2 = (s1, s2) -> {
        System.out.println("Compare");
        return Integer.compare(s1.length(), s2.length());
    };
//     -----------------------------------

    // equal expressions
    Runnable r = new Runnable(){
        public void run(){
            int i = 0;
            while(i++ < 10){
                System.out.println("It's work!!!");
            }
        }
    };

    Runnable r1 = () -> {
        int i = 0;
        while(i++ < 10){
            System.out.println("It's work!!!");
        }
    };

//    ---------------------------------------

    Function<Person, Integer> f = person -> person.getAge();

    Function<Person, Integer> f1 = Person::getAge;

    BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
    BinaryOperator<Integer> sum1 = (i1, i2) -> Integer.sum(i1, i2);

    BinaryOperator<Integer> sum2 = Integer::sum;
    BinaryOperator<Integer> max = Integer::max;

    //Consumer not return - it only do
    Consumer<String> printer = s -> System.out.println(s);
    Consumer<String> printer1 = System.out::println;


    public static void main(String[] args) {


    }
}
