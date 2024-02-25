
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 문제 꼼꼼히 읽기.
public class Bj_G4_17281_야구 {
    static int[][] arr;
    static int n,res;
    static int player_index;
    static int[] temp_team;
    static boolean[] isvisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][9];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 9 개중에 4번타자는 1번선수가 이미 들어가 있음.
        isvisited = new boolean[9];
        temp_team = new int[9];
        // 4번에 1번선수
        res = 0;
        p(0);
//        temp_team = new int[] {3, 5, 8, 0, 6, 2, 4, 1, 7};
//        go();
        System.out.println(res);
    }

    static void p(int count){
        // 9개인데 4번 타자는 정해주니까 8까지만
        if (count == 9){
            go();
        }
        // 4타자를 정하는 순서가 되면 이미 있으므로 다음으로 넘겨줌
        if (count == 3){
            // 5번 타자 정하게 보내줌.
            temp_team[count] = 0;
            p(4);
        }
        for (int i = 1; i < 9; i++) {
            if(isvisited[i]) continue;
            isvisited[i] = true;
            temp_team[count] = i;
            p(count+1);
            isvisited[i] = false;
        }
    }

    private static void go() {
        player_index = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int score = play(i);
            ans += score;
        }
        if (res < ans) res = ans;
//        System.out.println(Arrays.toString(temp_team) + "+" + ans);
    }

    private static int play(int ining) {
        int score = 0;
        int out = 0;
        // 그라운드
        int[] ground = new int[3];
        while (out < 3){
            player_index = (player_index + 1) % 9;
            //[3, 5, 8, 0, 6, 2, 4, 1, 7]+106
            int hit = arr[ining][temp_team[player_index]];
//            System.out.println(Arrays.toString(ground));
//            System.out.println(ining + " ining " + score + " out " + out);
//
//            System.out.println(player_index);
//            System.out.println(temp_team[player_index]);
//            System.out.println(hit);

            // 아웃이면 아웃 카운트 늘려주고 넘겨주기.
            if (hit == 0) {
                out += 1;
                continue;
            }

            // 홈런이면 그라운드 수 + 1해주고 넘겨주기
            if (hit == 4){
                int temp_score = 1;
                for (int i = 2; i >= 0; i--){
                    if (ground[i] == 1) temp_score++;
                    ground[i] = 0;
                }
                score += temp_score;
                continue;
            }

            for (int i = 2; i >= 0; i--){
                if (ground[i] == 0) continue;
                // 있으면 그자리 비워주고 다음으로 옮겨줌
                ground[i] = 0;
                // 3이면 홈이니까 점수 올려주기
                if (i + hit >= 3) {
                    score++;
                    continue;
                }
                // 아니라면 선수 채워주기
                ground[i+hit] = 1;
            }
//            System.out.println(hit);
            ground[hit-1] = 1;

        }
        return score;
    }
}

