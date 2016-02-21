package smal.tasks;

public class RegExp {

    public static boolean validateEmail(String string){
        return string.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    }

    public static boolean validateUrl(String string){
        return string.matches("^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$");
    }

    public static boolean validateNumberPhone(String string){

        //number template +??(???)???-??-??
        return string.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
    }
}
