package chapter01;


/**
 * @WIRTE ellie.song
 * 문자열에서 여백 제거
 */
public class Chapter008 {

    private final static String str = "hello world";

    public static void main(String[] args) {

        String replace = str.replace(" ", "");
        String replaceReg = str.replaceAll("\\s", "");

        System.out.println(replace);
        System.out.println(replaceReg);
    }
}
