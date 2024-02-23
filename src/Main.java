import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
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
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

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
            p(count+1);
            isvisited[i] = false;
        }
    }

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
    }
}
