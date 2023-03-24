package chapter01;

/**
 * @WIRTE ellie.song
 * 모든 순열 생성 ==  재귀
 */
public class Chapter010 {

    public static void permuteAndPrint(String str) {
        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String str) {
        int n = str.length();

        if(n == 0) {
            System.out.println(prefix + " ");
        } else {
            for(int i=0; i<n; i++) {
                permuteAndPrint(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)
                );
            }
        }
    }

    public static void main(String[] args) {
        Chapter010.permuteAndPrint("ABC");
    }
}
