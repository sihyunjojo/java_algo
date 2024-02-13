import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회의실 배정
// 굳이 배열을 업데이트 할 필요가 없이,
public class Bj_2839_S4_설탕배달 {
    static int result,n,arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int result = 0;
        // 3,5
        int[] dp = new int[n/5+1];
        for (int i = 0; i <= n/5; i++){
            int temp = n;

            dp[i] += i;
            temp -= i * 5;
            System.out.println("temp =" + temp);

            if (temp % 3 == 0){
                dp[i] += temp/3;
            } else if ((n%3) == 0){
                dp[i] = n/3;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }

        }

        int max = Arrays.stream(dp).min().orElse(0);
        if (Integer.MAX_VALUE == max){
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }


}