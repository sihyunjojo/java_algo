import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int res;
    static int[] temp_list;
    static int[][] init_board,board;
    static boolean[][] isvisited;
    static int n,m,board_size;
    static int[][] delta = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init_board = new int[n][m];
        isvisited = new boolean[n][m];
        temp_list = new int[2];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                init_board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        board_size = n * m;
        board = new int[n][m];
        back_board();
        combi(0,0);
// 200 * 399 * bfs ==
        System.out.println(res);
    }
    static void combi(int start, int count){
        if (count == 2){
            back_board();
            delete_rock(temp_list);
            return;
        }
        for (int i = start; i < board_size; i++) {
            temp_list[count] = i;
            combi(i+1,count+1);
        }

    }

    // 돌 2개 넣어주고
    // 2 돌 하나 찾아서
    // 그 돌 리스트에 두고
    // 1 또는 2 있으면 패스 // 2가 있으면 리스트에 넣고 + 큐에 추가
    // 0이 하나라도 있으면 브레이크 안됨.
    static void delete_rock(int[] rock_list){
        int count = 0;
        isvisited = new boolean[n][m];

        int y = 0;
        int x = 0;
        for (int rock : rock_list) {
            y = rock / m;
            x = rock % m;
//            System.out.println(y + " " + x);
            if (board[y][x] != 0) return;
            board[y][x] = 1;


//            for (int d = 0; d < 4; d++) {
//                int dy = y + delta[d][0];
//                int dx = x + delta[d][1];
//                if (check_size(dy,dx) && !isvisited[dy][dx]) {
//                    if (board[dy][dx] == 2) {
//                        q.add(new int[] {dy,dx});
//                        isvisited[dy][dx] = true;
//                    }
//                }
//            }
        }
//0 1
//0 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                isvisited = new boolean[n][m];
                if(board[i][j] == 2 && !isvisited[i][j]){
                    int flag = 0;
                    int tmp_count = count;

                    Queue<int[]> q = new ArrayDeque<>();
                    Queue<int[]> aq = new ArrayDeque<>();

                    q.add(new int[] {i,j});
                    aq.add(new int[] {i,j});
                    isvisited[i][j] = true;
//                    System.out.println("iiiiiii" + i + " " + j);
                    count++;



                    loop:
                    while (!q.isEmpty()){
                        int[] poll = q.poll();
                        y = poll[0];
                        x = poll[1];
                        for (int d = 0; d < 4; d++) {
                            int dy = y + delta[d][0];
                            int dx = x + delta[d][1];
                            if (check_size(dy,dx)) {
//                                System.out.println("11 "+ dy + " " +dx + " " + count);
                                if (board[dy][dx] == 0){
//                                    System.out.println("break " + dy + " " + dx);
                                    for (int[] ints : aq) {
                                        isvisited[ints[0]][ints[1]] = false;
//                                        System.out.println("222" + Arrays.toString(ints));
                                    }
//                                    for (boolean[] booleans : isvisited) {
//                                        System.out.println(Arrays.toString(booleans));
//                                    }
                                    count = tmp_count;

                                    break loop;
                                }
                                if (board[dy][dx] == 1) continue;
                                if (board[dy][dx] == 2 && !isvisited[dy][dx]){
                                    q.add(new int[] {dy,dx});
                                    aq.add(new int[] {dy,dx});
//                                    System.out.println("in " + dy + " "+ dx);
                                    isvisited[dy][dx] = true;
                                    count++;
                                }

                            }
                        }
                    }
//                    System.out.println("ccccntnnt " + count );
//                    print_board();
//                    for (boolean[] booleans : isvisited) {
//                        System.out.println(Arrays.toString(booleans));
//                    }
//                    System.out.println("cnt " + count + "i " + i + "j " + j);
                }
            }
        }

//        System.out.println("count" + count);
//        System.out.println();

        if (res < count) res = count;
    }

    static boolean check_size(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static void back_board(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = init_board[i][j];
            }
        }
    }

    static void print_board(){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
