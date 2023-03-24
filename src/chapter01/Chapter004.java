package chapter01;

/**
 * @WIRTE ellie.song
 * 숫자만 포함하는 문자열인지 검사
 * 1. Character.isDigit
 * 2. chars().anyMatch (stream)
 * 3. str.matches
 */
public class Chapter004 {

    public static boolean containsOnlyDigits1(String str) {
        for(int i = 0; i < str.length(); i++)
            if(!Character.isDigit(str.charAt(i))) return false;

        return true;
    }

    public static boolean containsOnlyDigits2(String str) {
        return !str.chars().anyMatch(x-> !Character.isDigit(x));
    }

    public static boolean containsOnlyDigits3(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) {

        String str = "string1";

        System.out.println(containsOnlyDigits1(str));
        System.out.println(containsOnlyDigits2(str));
        System.out.println(containsOnlyDigits3(str));

    }
}
