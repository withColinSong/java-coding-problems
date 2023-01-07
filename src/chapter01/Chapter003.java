package chapter01;


import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @WIRTE ellie.song
 * 글자와 단어 뒤집기
 */
public class Chapter003 {

    public static String reverseWord1(String str) {

        StringBuilder reversedString = new StringBuilder();

        for (int i = 1; i <= str.length(); i++) {
            reversedString.append(str.charAt(str.length()-i));
        }

        return reversedString.toString();
    }

    private static final String WHITESPACE = " ";
    public static String reverseWord2(String str) {
        String[] words = str.split(WHITESPACE);

        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length()-1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }

            reversedString.append(reversedWord).append(WHITESPACE);
        }

        return reversedString.toString();

    }

    private static final Pattern PATTERN = Pattern.compile(" ");
    public static String reverseWord3(String str) {
        return PATTERN.splitAsStream(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

        String str = "good!";
        System.out.println(reverseWord1(str));
        System.out.println(reverseWord2(str));
        System.out.println(reverseWord3(str));
    }
}
