import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static char[][] board;
    static int r,c,res;
    static int[][] delta = new int[][] {{-1,1},{0,1},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Measure_time.runFunction(() -> {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < r; i++){
            if(dfs(i, 0)) res++;
        }
        System.out.println(res);
        });

    }
    static boolean dfs(int y, int x){
        if (x == (c - 1)){
            return true;
        }
        for (int d = 0; d < 3; d++){
            int dy = y + delta[d][0];
            int dx = x + delta[d][1];
            if (check_size(dy) && board[dy][dx] == '.'){
                board[dy][dx] = '!';
                if (dfs(dy,dx)) return true;
//                board[dy][dx] = '.';
            }
        }
        return false;
    }
    static boolean check_size(int y){
        return 0 <= y && y < r;
    }

    static void print_board(){
        for (char[] chars : board) {
            System.out.println(chars);
        }
        System.out.println();
    }
}


//시간차이(ms) : 1.1815664
//시간차이(ms) : 1.3530674
