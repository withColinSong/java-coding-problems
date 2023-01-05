package chapter01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @WIRTE ellie.song
 * 반복되지 않는 첫번째 문자 찾기
 */
public class Chapter002 {

    public static char firstNonRepeatedCharacter(String str) {

        // 삽입 순서를 유지하기 때문에 LinkedHashMap 사용
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.compute(c, (k,v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {

        String str = "dev-coding-dev";
        Character character = firstNonRepeatedCharacter(str);
        System.out.println(character);

    }
}
