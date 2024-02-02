import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_Silver3_15649_n과m1 {
    static int[] arr;
    static int m,n;
    // String builder를 사용하면 속도가 배로 빠르다.
    // BufferedWriter를 사용해도 된다.
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        n = s.charAt(0) - '0';
        m = s.charAt(2) - '0';

        arr = new int[m];

        per(0);
        // 이 코드
        System.out.println(sb);

    }
    private static void per(int count){
        if (count == m){
            for (int i = 0; i < m; i++){
                // 이 코드
                sb.append(arr[i]).append(' ');
            }
            // 이 코드
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= n; i++){
            arr[count] = i;
            per(count+1);
        }
    }
}
