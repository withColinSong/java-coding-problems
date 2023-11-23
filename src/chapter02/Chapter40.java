package chapter02;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @WIRTE ellie.song
 * 함수형 스타일과 절차적 코드에서 null 참조 검사
 */
public class Chapter40 {

    // 1. 기존
    public static List<Integer> evenIntegers1(List<Integer> integers) {
        if(integers == null)
            return Collections.EMPTY_LIST;

        List<Integer> evens = new ArrayList<>();
        for (Integer nr : integers) {
            if(nr != null && nr % 2 == 0) {
                evens.add(nr);
            }
        }

        return evens;
    }

    // 2. object == null  혹은 Objects.isNull
    public static List<Integer> evenIntegers2(List<Integer> integers) {
        if(Objects.isNull(integers))
            return Collections.EMPTY_LIST;

        List<Integer> evens = new ArrayList<>();
        for (Integer nr : integers) {
            if(Objects.nonNull(nr) && nr % 2 == 0) {
                evens.add(nr);
            }
        }

        return evens;
    }

    // 3. 함수형 스타일 predicate 이용하기
    public static List<Integer> evenIntegers3(List<Integer> integers) {
        if(integers == null)
            throw new IllegalArgumentException("List can't be null");

        return  integers.stream()
                .filter(Objects::nonNull)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
        List<Integer> numbersNull = new ArrayList<>();

        System.out.println(evenIntegers2(numbersNull));
        System.out.println(evenIntegers3(numbersNull));
    }
}
