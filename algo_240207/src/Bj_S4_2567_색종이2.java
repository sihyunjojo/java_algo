import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 색종이 2
// 테두리만 따로 표시해서 나중에 세려주면 될듯. (이럼 좀 힘든 방식이 될듯)
// 표시된거 만나면 break;

// 그래서 그냥 전부 색칠한다음에
// 테두리 조건으로 걸러서 만들어줌.

// 처음에는 8방으로 0이면 했는데 그럼 가로 한번 세로 한번 새리는게 안되서 바꿈.
public class Bj_S4_2567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[100][100];

        int result = 0;

        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 10; j++){
                for (int k = 0; k < 10; k++){
                    board[h+j][w+k] = 1;
                }
            }
        }

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

        // 0 ~ 1 -> 0 99 ~ 100 -> 99
//        int[][] delta = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
        int[][] delta = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (board[i][j] == 1) {
                    for (int d = 0; d < 4; d++){
                        int dx = j + delta[d][0];
                        int dy = i + delta[d][1];
                        if (0 <= dx && dx < 100 && 0 <= dy && dy < 100 && board[dy][dx] == 0){
                            result += 1;
                            System.out.println(i+" "+j);
                        }

                        if (dx < 0 || 100 <= dx || dy < 0 || 100 <= dy){
                            result += 1;
                        }
                    }

                }
            }
        }
        System.out.println(result);
    }
}