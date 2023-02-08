package chapter01;

/**
 * @WIRTE ellie.song
 * 문자열을 int, long, float, double로 변환
 * 문자열을 성공적으로 변환하지 못하면 예외를 던지기 때문에 예외처리 추가
 */
public class Chapter007 {

    public static final String str1 = "1234w";
    public static final String str2 = "123";

    public static void main(String[] args) {

       try {

           int toInt = Integer.parseInt(str1);
           long toLong = Long.parseLong(str1);
           float toFloat = Float.parseFloat(str1);
           double toDouble = Double.parseDouble(str1);

           // 객체로 변경하려면 valueOf를 사용한다.
           Integer toInteger = Integer.valueOf(str2);

       } catch (NumberFormatException e) {
           System.out.println(e);
       }

    }
}
