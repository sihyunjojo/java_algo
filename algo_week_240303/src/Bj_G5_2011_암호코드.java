import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_G5_2011_암호코드 {
    static StringBuilder sb = new StringBuilder();
    static char[] s;
    static int[] dp;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().toCharArray();
        res = 0;
        // 9 10 7

        System.out.println(res);
    }
    static void pass(){
        if (s[0] == 0) {
            return;
        }
        for (int i = 1; i < s.length; i++) {
            if(s[i] == 0 && 2 < s[i-1]){
                break;
            }
            if(s[i] == 0 && 0 == s[i-1]){
                break;
            }
            if (7 <= s[i] && 2 < s[i-1]){
                // 하나만 존재.

            }
        }
    }
}