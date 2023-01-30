package chapter01;

import java.util.*;

/**
 * @WIRTE ellie.song
 * 모음과 자음세기
 * 1. inner class 제네릭 이용하기
 */
public class Chapter005 {

    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    // generic
    private static class Pair<T, T1> {
        T left;
        T1 right;

        public static Pair<Integer, Integer> of(int x, int y) {
            return new Pair<>(x, y);
        }

        private Pair(T left, T1 right) {
            this.left = left;
            this.right = right;
        }
    }

    public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {

        String s = str.toLowerCase();

        int vowels = 0;         // 모음
        int consonants = 0;     // 자음

        for (int i = 0; i < str.length(); i++) {
            char ch = s.charAt(i);

            if(allVowels.contains(ch)) {
                vowels++;
            } else if((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }

        return Pair.of(vowels, consonants);
    }

    public static void main(String[] args) {

        String str = "ellie.song";
        Pair<Integer, Integer> integerIntegerPair = countVowelsAndConsonants(str);
        System.out.println(integerIntegerPair.left);
        System.out.println(integerIntegerPair.right);

    }

}
