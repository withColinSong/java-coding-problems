package chapter02;

import java.lang.reflect.Field;

/**
 * 문자열은 불변인가?
 */
public class Chapter48 {
    public static void main(String[] args) {
        String user = "guest";
        System.out.println("User is of type: " + user);

        Class<String> type = String.class;
        try {
            Field field = type.getDeclaredField("value");
            System.out.println(field);
            field.setAccessible(true);

            // jdk 11에서는 'java.lang.ClassCastException' exception 통해 불변 가능
            try {
                char[] chars = (char[]) field.get(user);
                chars[0] = 'a';
                chars[1] = 'd';
                chars[2] = 'm';
                chars[3] = 'i';
                chars[4] = 'n';

                System.out.println("User is of type: " + user);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
