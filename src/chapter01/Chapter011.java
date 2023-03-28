package chapter01;

import java.util.stream.IntStream;

/**
 * @WIRTE ellie.song
 * 문자열 회문
 * Palindrome :  회문
 */

public class Chapter011 {


    public static boolean Palindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        boolean result = true;

        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                result = false;
            }
            left++;
            right--;
        }

        return result;

    }

    public static boolean Palindrome2(String str) {

        int n = str.length();
        boolean result = true;
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                result = false;
            }
        }

        return result;
    }

    public static boolean Palindrome3(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean Palindrome4(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p ->  {
                    return str.charAt(p) != str.charAt(str.length() - p - 1);
                });
    }

    public static void main(String[] args) {

        System.out.println(Palindrome("madams"));
        System.out.println(Palindrome2("madam"));
        System.out.println(Palindrome3("madam"));
        System.out.println(Palindrome4("madams"));

    }
}
