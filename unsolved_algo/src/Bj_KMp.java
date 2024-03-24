import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_KMp {
    static StringBuilder sb = new StringBuilder();
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();


        int[] table = new int[s.length()];

        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1]; // 이전 테이블 값 가져오면서 그
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++; // j는 1을 증가해서 다음 반복문에서 비교할 변수 준비 (+1 과 마지막을 비교해야하니)
                table[i] = j; // j는 위에서 1을 증가시켜줘야지 인덱스 + 1이므로 개수가 들어간다.
            }
        }

        System.out.println(Arrays.toString(table));

        j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                if (j == s.length() - 1) {
                    System.out.printf("%d번째 에서 찾았습니다\n", i - j + 1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}