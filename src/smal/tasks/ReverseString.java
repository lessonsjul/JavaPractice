package smal.tasks;

public class ReverseString {

    public static String reverseString(String string) {
        StringBuilder builder = new StringBuilder(string);

        builder = builder.reverse();

        return new String(builder);
    }
}
