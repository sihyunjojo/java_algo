import java.io.*;
import java.util.*;

// 재귀에서 time을 time에 따라서 함수들의 순서를 어떻게 구현하고 안에 time인자가 들어가야하는 부분을 어떻게 설정해야할지에 대해서 고민이 조금 더 필요함.

public class Swea_2115_벌꿀채취 {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int n,m,c,res,temp_money;
    static int[] temp_honey,honeybox;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            for (int i = 0; i < n; i++) {
                // 그 맨뒤에 전까지 해줘야하니
                for (int j = 0; j <= n-m; j++) {
                    int[] first_honey_box = make_honey_box(i, j);
//                    System.out.println(Arrays.toString(first_honey_box));
                    honeybox = first_honey_box;
                    int first_honey_money = max_money();
                    int second_honey_money = make_second_honey_box_money(i, j);
                    int point_max_money = first_honey_money + second_honey_money;
                    if(res < point_max_money) res = point_max_money;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    // 완벽
    static int[] make_honey_box(int y, int x){
        int[] honey_box = new int[m];
        // m 만큼 넣어서 만들어줌.
        for (int i = 0; i < m; i++) {
            honey_box[i] = board[y][x+i];
        }
        return honey_box;
    }

    //
    static int make_second_honey_box_money(int y, int x){
        int second_max_money = 0;
        for (int i = y; i < n; i++) {
            int j = 0;
            // 같은 줄이면,
            if (i == y) j = x + m;
            for (;j <= n-m; j++) {
                honeybox = make_honey_box(i, j);
//                System.out.println("secondbox" +
//                        Arrays.toString(honeybox));
                int max_money = max_money();
                if (second_max_money < max_money) second_max_money = max_money;
            }
        }
        return second_max_money;
    }

    private static int max_money() {
        int max_money = 0;
        for (int i = 1; i <= m; i++) {
            temp_money = 0;
            temp_honey = new int[i];
            combi(i,0,0);
            if (max_money < temp_money) max_money = temp_money;
        }
        return max_money;
    }

    // 조합
    private static void combi(int r,int count,int start) {
        if (count == r) {
            if (check_max_work()) {
                int ans = cal_money();
                if (temp_money < ans) temp_money = ans;
            }
            return;
        }
        for (int i = start; i < m; i++) {
            temp_honey[count] = honeybox[i];
            combi(r, count + 1, i + 1);
        }
    }

    static boolean check_max_work(){
        int work = 0;
        for (int i = 0; i < temp_honey.length; i++){
            work += temp_honey[i];
        }
        return work <= c;
    }
    // 그 조합에 맞는 돈
    private static int cal_money() {
        int money = 0;
        for (int i = 0; i < temp_honey.length; i++){
            money += (int) Math.pow(temp_honey[i],2);
        }
        return money;
    }
}