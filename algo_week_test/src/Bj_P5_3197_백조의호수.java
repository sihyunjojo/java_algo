package abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj_P5_3197_백조의호수 {
    static int r,c;
    static char[][] board;
    static ArrayList<int[]> ices;
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    static int[][] person;
    static boolean[][] isvisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i]= br.readLine().toCharArray();
        }

        person = new int[2][2];
        int p_index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'L') {
                    person[p_index][0] = i;
                    person[p_index++][1] = j;
                }
            }
        }

//		int p_distance = Math.abs(person[0][0] - person[1][0]) + Math.abs(person[0][1] - person[1][1]);
//		int plus = p_distance % 2;
//		if (plus == 1) {
//			p_distance += 1;
//		}
//		int real_p_distance = p_distance / 2;
//
//		System.out.println(real_p_distance);

        int time = 0;
        while(true) {
            isvisited = new boolean[r][c];
            go();
            time++;
            if (move_peple()) {
                break;
            }
        }
        System.out.println(time);

    }
    static void go() {
        ices = new ArrayList<>();

        // 녹아야하는 빙하 체크
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'X') {
                    for (int d = 0; d < 4; d++) {
                        int dy = i + delta[d][0];
                        int dx = j + delta[d][1];

                        if (check_size(dy,dx) && board[dy][dx] == '.') {
                            ices.add(new int[] {i,j});
                        }
                    }
                }
            }
        }

        // 빙하 녹이기
        for (int i = 0; i < ices.size(); i++) {
            int[] temp = ices.get(i);
            board[temp[0]][temp[1]] = '.';
        }
    }

    static boolean check_size(int y, int x) {
        return 0 <=x && x < c && 0 <= y && y < r;
    }

    static boolean move_peple(){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {person[0][0],person[0][1]});
        isvisited[person[0][0]][person[0][1]] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for (int d = 0; d<4; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];
                if(check_size(dy, dx) && dy == person[1][0] && dx == person[1][1]) {
                    return true;
                }
                if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == '.') {
                    q.add(new int[] {dy,dx});
                    isvisited[dy][dx] = true;
                }
            }
        }

        return false;


    }

}