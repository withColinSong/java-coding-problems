package chapter01;


/**
 * @WIRTE ellie.song
 * 문자 빈도수 세기
 */
public class Chapter006 {

    public static int countOccurrencesOfACertainCharacter1(String str, char ch) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static int countOccurrencesOfACertainCharacter2(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    // stream
    public static Long countOccurrencesOfACertainCharacter3(String str, char ch) {
        return str.chars().filter(c-> c == ch).count();
    }

    public static void main(String[] args) {

        String str = "hello hello gfgdfgello";
        char ch = 'o';

        System.out.println(countOccurrencesOfACertainCharacter1(str, ch));
        System.out.println(countOccurrencesOfACertainCharacter2(str, ch));
        System.out.println(countOccurrencesOfACertainCharacter3(str, ch));

    }
}
