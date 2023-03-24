package chapter01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @WIRTE : ellie.song
 * 문자 개수 새기
 */
public class Chapter001 {

    public static Integer CountStringSum1(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result.values().stream().reduce(0, Integer::sum);
    }

    public static Long CountStringSum2(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().stream().reduce(0L, Long::sum);
    }

    public static void main(String[] args) {

        String str = "yeonju.song@test.com";
        System.out.println(CountStringSum1(str));
        System.out.println(CountStringSum2(str));
        System.out.println(str.length());


    }
}
