package chapter01;


import java.util.StringJoiner;

/**
 * @WIRTE ellie.song
 * 구분자로 여러 문자열 합치기
 */
public class Chapter009 {

    public static final String a = "hello";
    public static final String b = "world";
    public static final String c = "!!!!!";

    public static final String delimiter = " ";

    public static String JoinByDelimiterUseStringBuilder(String separator, String ... args) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        for (i = 0; i < args.length - 1; i++)
            result.append(args[i]).append(separator);

        result.append(args[i]);

        return result.toString();
    }

    public static String JoinByDelimiterUseStringJoiner(String separator, String ... args) {

        StringJoiner result = new StringJoiner(String.valueOf(separator));

        for (String arg : args)
            result.add(arg);

        return result.toString();
    }

    public static String JoinByDelimiterUseStringJoin(String separator, String ... args) {
        return String.join(separator, args);
    }

    public static void main(String[] args) {

        System.out.println(JoinByDelimiterUseStringBuilder(delimiter , a,b,c));
        System.out.println(JoinByDelimiterUseStringJoiner(delimiter , a,b,c));
        System.out.println(JoinByDelimiterUseStringJoin(delimiter , a,b,c));

    }
}
