<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
=======
>>>>>>> 1f72b29d3bfb2eaf681a39cbae41aec9e014e860

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.SimpleFileVisitor;
import java.util.*;


// 문제 꼼꼼히 읽기.
public class Main {
    static int[][] arr;
<<<<<<< HEAD
    static int[] temp_arr;
    static int n,res,temp_outcount;
    static boolean[] isvisited;
    static int[] ground;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][10];
        isvisited = new boolean[10];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++){
=======
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
>>>>>>> 1f72b29d3bfb2eaf681a39cbae41aec9e014e860
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

<<<<<<< HEAD
        temp_arr = new int[9];
        temp_arr[3] = 1;

        p(0);

        System.out.println(res);
    }
    // 사람은 1,2,3,4 순서는 0,1,2,3
    static void p(int count){
        if (count == 9){
            System.out.println(Arrays.toString(temp_arr));
            int go = go();
            if (res < go) res = go;
            return;
        }
        if (count == 3){
            p(4);
        }
        for (int i = 2; i <= 9; i++){
            if (isvisited[i]) continue;
            isvisited[i] = true;
            temp_arr[count] = i; // 넣어줌.
=======
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
>>>>>>> 1f72b29d3bfb2eaf681a39cbae41aec9e014e860
            p(count+1);
            isvisited[i] = false;
        }
    }

<<<<<<< HEAD
    static int go(){
        int temp_res = 0;
        for (int i = 0; i < n; i++){
            temp_outcount = 0;
            ground = new int[5];

            int score = move_ground(i);

            temp_res += score;
        }
        return temp_res;
    }


    static int move_ground(int ining){
        int ining_score = 0;
        for (int j = 0; j < 9; j++){
            int hit = arr[ining][temp_arr[j]];

            if (temp_outcount >= 3){
                break;
            }

            // 계속 돌려.
            if (j == 8){
                j = -1;
            }

            if (hit == 0) {
                temp_outcount++;
                continue;
            }

            for (int i = 4; i > 0; i--){
                if(ground[i] == 0) continue;
                ground[i] = 0;
                if (i + hit >= 4) {
                    ining_score += 1;
                } else {
                    ground[i + hit] = 1;
                }
            }
            ground[hit] = 1;
        }
        return ining_score;
=======
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
>>>>>>> 1f72b29d3bfb2eaf681a39cbae41aec9e014e860
    }
}

