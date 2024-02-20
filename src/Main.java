import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] board;
    static int  hei,wid,time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        hei = Integer.parseInt(st.nextToken());
        wid = Integer.parseInt(st.nextToken());

        board = new int[hei][wid];
        for (int i = 0; i < hei; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < wid; j++){
                 board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        while(true){

            time++;
            if (count_cheese()==0) break;
            res = count_cheese();
        }
        System.out.println(time);
        System.out.println(res);
    }
    static void disappearing_cheese(){


    }
    static int count_cheese(){
        int cnt = 0;
        for (int i = 0; i < hei; i++){
            for (int j = 0; j < wid; j++){
                if (board[i][j] > 0){
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}




