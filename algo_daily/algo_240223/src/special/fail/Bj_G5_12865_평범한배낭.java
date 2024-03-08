package special.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_G5_12865_평범한배낭 {
    static class Tool {
        int w;
        int v;

        public Tool(int w, int v) {
            this.w = w;
            this.v = v;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Tool> tools = new ArrayList<>();
        ArrayList<Tool> tools1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Tool tool = new Tool(w, v);
            tools1.add(tool);
            tools.add(tool);
        }

        tools.sort(((o1, o2) -> {
            return -(o1.v / o1.w - o2.v / o2.w);
        }));

        tools.sort(((o1, o2) -> {
            return -(o1.w - o2.w);
        }));

        int[][] dp = new int[n][k + 1];

        for (int i = 1; i < k; i++) {

        }

    }

}
// (Wi, Vi) = (6, 13), (4, 8), (3, 6), (5, 12)
// i가 채위지면 그 이후에 더 작은 값이라면 다 그 값으로 바꿔준다.
//이전 i값에 대한 dp에 메모이제이션 되어있는 값을 갖고와야한다. () i == 0인 경우는 이전 값이 존재 하지 않는다.


// 중요) 같은 무게의 이전 i의 값을 가져온다. dp[7][1] == 13
// dp[7][2]구하는 중...
// 그 이후  dp의 무게인 값(7) - W[2] = 7 - 4 = 3
// 3이라는 무게에 대응하는 (dp[3]) i가 1일 떄 값 (지금 i는 2니까 이전인 i가 1일 때 값)
// W[2]와 dp[3][1]인 이 둘을 합하면 8이 되고 최댓값은 13이므로 13

// 이걸 반복해.

// 이걸 bottom - up 방식으로 구현하면 진짜 짧아진다.