package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 어떠한 동전들의 조합으로도 정확한 물건값이 될 수 없는 경우는 입력으로 주어지지 않는다.
// 그럼 뒤에서 부터 최대한 넣어주면 되지 않을까??
public class J1183_동전자판기하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 되도록 많은 개수의 동전을 사용한다.
        // 정확한 돈을 넣어야한다.

        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[][] coins = new int[][]{{500, 0}, {100, 0}, {50, 0}, {10, 0}, {5, 0}, {1, 0}};
        int[] result = new int[]{0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 6; i++) {
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 5; i > 0; i--) {
            if (coins[i][1] == 0) continue;
            System.out.println("i = " + i);
            int change = w % coins[i - 1][0]; // 거스름돈
            int coin_count = change / coins[i][0];

            if (coin_count <= coins[i][1]){
                w -= change;
                result[i] += coin_count;
                coins[i][1] -= coin_count;
            }

            System.out.println(Arrays.toString(result));
            coin_count = coins[i - 1][0] / coins[i][0];

            while (coins[i][1] >= coin_count && w > 0) {
                result[i] += coin_count;
                coins[i][1] -= coin_count;
                w -= coin_count * coins[i][0];
            }
            System.out.println(Arrays.toString(result));
        }

        result[0] = w / 500;
        coins[0][1] -= w / 500;
        w -= result[0] * 500;

        for (int[] coin : coins) {
            System.out.println(Arrays.toString(coin));
        }
        if (w > 0){
            for (int i = 0; i < 6; i++){
                if (coins[i][1] == 0 || coins[i][0] < w) continue;
                // 하나를 주고 나머지를 더 받는 코드
                int charge = coins[i][0] - w;
                w -= coins[i][0];
                result[i] += 1;
                for (int j = i+1; j < 6; j++){
                    if (coins[j][0] > charge || coins[j][1] == 0) continue;

//                    result[i] -= //
//                    coins[j][1] += //
//                                    w += //
                }
            }
        }
        System.out.println(Arrays.stream(result).sum());
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(w);
    }
}