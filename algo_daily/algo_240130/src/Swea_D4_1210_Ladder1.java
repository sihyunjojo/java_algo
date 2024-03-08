import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_D4_1210_Ladder1 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./input2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        0’으로 채워진 평면상에 사다리는 연속된 ‘1’로 표현된다. 도착 지점은 '2'로 표현된다).


        for (int tc = 0; tc < 10; tc++){
            int t = Integer.parseInt(br.readLine());

            int[][] board = new int[100][100];
            int x = 0;
            for (int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 2) x = j;
                }
            }

            int y = 99;
            while (y > 0){
                if (isBound(y,x+1) && board[y][x+1] == 1){
                    while (isBound(y,x+1) && board[y][x+1] == 1){
                        x += 1;
//                        System.out.println("x"+x);
                    }
                    y--;
                    continue;
                }
                if (isBound(y,x-1) && board[y][x-1] == 1){
                    while (isBound(y,x-1) && board[y][x-1] == 1){
                        x -= 1;
//                        System.out.println("-x"+x);
                    }
                    y -=1;
//                    System.out.println(y);
                    continue;
                }

                if (isBound(y-1,x) && board[y-1][x] == 1){
                    y -= 1;
//                    System.out.println(y);
                }
            }
            System.out.printf("#%d %d\n",t, x);
        }
    }
    public static boolean isBound(int y, int x) {
        return y >= 0 && x >= 0 && y < 100 && x < 100;
    }
}
