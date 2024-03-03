import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 입구 도착 후 1분 뒤에 내려갈 수 있음
// 계단 위에 동시 최대 3명까지만 가능
// 이미 계단 3명 내려가고 있는 경우, 1명이 완전히 내려갈 때까지 계단입구에서 대기
public class Swea_1952_수영장 {
    static StringBuilder sb = new StringBuilder();
    static int[] swim_prices, swim_plans, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            swim_prices = new int[4];
            swim_plans = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                swim_prices[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                swim_plans[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[13];
            // 1월달
            dp[1] = Math.min(swim_prices[1], swim_prices[0] * swim_plans[1]);
            // 2월달
            dp[2] = dp[1] + Math.min(swim_prices[1], swim_prices[0] * swim_plans[2]);
//            3달부터 시작.
            for (int i = 3; i <= 12; i++) {
                // 우선 그 달의 한달과 하루 이용권을비교 + 이전달까지의 비용
                int temp = dp[i - 1] + Math.min(swim_prices[1], swim_prices[0] * swim_plans[i]);
                int three_price = dp[i - 3] + swim_prices[2];
                dp[i] = Math.min(temp, three_price);
            }


            int res = Math.min(swim_prices[3], dp[12]);

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
