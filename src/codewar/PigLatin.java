package codewar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin {

    public static void main(String[] args) {
        System.out.println(new PigLatin().translate2("spagetti"));
    }
    public String translate(String str){
        //good code

        if(!str.matches("\\w+")) return null;

        str = str.toLowerCase();

        if(str.matches("^[a,e,i,o,u]+\\w*")) return str + "way";

        if(str.matches("\\w*[a,e,i,o,u]+\\w*")) {
            int vowel = str.replaceAll("[a,e,i,o,u]", "?").indexOf("?");
            StringBuilder stb = new StringBuilder(str.substring(vowel)).append(str.substring(0,vowel));
            str = stb.toString();
        }

        return str + "ay";
    }

    public String translate2(String str){
        if (str == null) return null;

        str = str.toLowerCase();

        if (containsNonAlpha(str)) return null;
        if (startsWithVowel(str)) return str + "way";

        // Starts with consonant
        Matcher m = Pattern.compile("[^aeiou]+").matcher(str);
        m.find();
        String end = m.group();
        return str.substring(end.length(), str.length()) + end + "ay";
    }

    private boolean containsNonAlpha(String str) {
        return str.matches("[a-z]*[^a-z]+.*");
    }

    private boolean startsWithVowel(String str) {
        return str.matches("[aeiou].*");
    }
}
