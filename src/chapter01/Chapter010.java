package chapter01;

import java.util.Date;
import java.util.stream.IntStream;

/**
 * @WIRTE ellie.song
 * 모든 순열 생성 ==  재귀
 */
public class Chapter010 {

    public static void permuteAndPrint(String str) {
        // permuteAndPrint("", str);
        permuteAndPrintStream("", str);
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


    // parallel => pipeline을 병렬로 처리하라고 하는 정보를 제공해주는 메소드
    private static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();
        if(n == 0) {
            System.out.println(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i), str.substring(i + 1 , n) + str.substring(0, i)));
        }
    }

    public static void main(String[] args) {
        //Chapter010.permuteAndPrint("ABC");
        Chapter010.permuteAndPrint("ABC");
    }
}
