import java.io.*;
import java.util.*;


public class Swea_D3_1873_상호의배틀필드 {
    static StringBuilder sb = new StringBuilder();
    static char[][] board;
    static int h,w,n;
    static String s;
    static int[] start;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1873.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());


            board = new char[h][w];
            start = new int[3]; // y,x,바라보는 곳(상,하,좌,우)

            for (int i = 0; i < h; i++){
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++){
                    switch (board[i][j]){
                        case '^':
                            start = new int[] {i,j,0};
                            break;
                        case 'v':
                            start = new int[] {i,j,1};
                            break;
                        case '<':
                            start = new int[] {i,j,2};
                            break;
                        case '>':
                            start = new int[] {i,j,3};
                            break;
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int i = 0; i < n; i++){
                char c = s.charAt(i);
                switch (c){
                    case 'U':
                        start[2] = 0;
                        if (check(start[0]-1,start[1])) {
                            board[start[0]][start[1]] = '.';
                            start[0]--;
                            board[start[0]][start[1]] = '^';
                        }
                        break;
                    case 'D':
                        start[2] = 1;
                        if (check(start[0]+1,start[1])) {
                            board[start[0]][start[1]] = '.';
                            start[0]++;
                            board[start[0]][start[1]] = 'v';
                        }
                        break;
                    case 'L':
                        start[2] = 2;
                        if (check(start[0],start[1]-1)) {
                            board[start[0]][start[1]] = '.';
                            start[1]--;
                            board[start[0]][start[1]] = '<';
                        }
                        break;
                    case 'R':
                        start[2] = 3;
                        if (check(start[0],start[1]+1)) {
                            board[start[0]][start[1]] = '.';
                            start[1]++;
                            board[start[0]][start[1]] = '>';
                        }
                        break;
                    case 'S':
                        shoot();
                        break;
                }
//                System.out.println(c);
//                for (int j = 0; j < h; j++){
//                    System.out.println(board[j]);
//                }
//                System.out.println();
            }

            switch (start[2]){
                case 0:
                    board[start[0]][start[1]] = '^';
                    break;
                case 1:
                    board[start[0]][start[1]] = 'v';
                    break;
                case 2:
                    board[start[0]][start[1]] = '<';
                    break;
                case 3:
                    board[start[0]][start[1]] = '>';
                    break;
            }

            for (int i = 0; i<h; i++){
                sb.append(board[i]).append("\n");
            }

        }
        System.out.println(sb);
    }
    private static void shoot(){
        switch (start[2]){
            case 0:
                for (int i = start[0]-1; i >= 0; i--){
                    if (board[i][start[1]] == '*'){
                        board[i][start[1]] = '.';
                        break;
                    }
                    if (board[i][start[1]] == '#'){
                        break;
                    }
                }
                break;
            case 1:
                for (int i = start[0]+1; i < h; i++){
                    if (board[i][start[1]] == '*'){
                        board[i][start[1]] = '.';
                        break;
                    }
                    if (board[i][start[1]] == '#'){
                        break;
                    }
                }
                break;
            case 2:
                for (int i = start[1]-1; i >= 0; i--){
                    if (board[start[0]][i] == '*'){
                        board[start[0]][i] = '.';
                        break;
                    }
                    if (board[start[0]][i] == '#'){
                        break;
                    }
                }
                break;
            case 3:
                for (int i = start[1]+1; i < w; i++){
                    if (board[start[0]][i] == '*'){
                        board[start[0]][i] = '.';
                        break;
                    }
                    if (board[start[0]][i] == '#'){
                        break;
                    }
                }
                break;
        }
    }

    private static boolean check(int y, int x){
        return 0 <= x && x < w && 0 <= y && y < h &&
                board[y][x] != '*' && board[y][x] != '#' && board[y][x] != '-';
    }
}