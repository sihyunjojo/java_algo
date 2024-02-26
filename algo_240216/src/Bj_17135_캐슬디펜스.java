
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 꼼꼼히 읽기.
public class Bj_17135_캐슬디펜스 {
    static int n, m, d, res;
    static boolean[][] isvisited;
    static int[] temp_archers;
    static int[][] init_board , board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        res = 0;

        init_board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                init_board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 3명의 궁수들 인덱스 넣어줘야함.
        // 그러고 추후에 n,0 으로 만들어서 사용.

        temp_archers = new int[3];
        c(0, 0);
        System.out.println(res);
    }

    static void c(int count, int start) {
        if (count == 3) {
            go();
            return;
        }
        for (int i = start; i < m; i++) {
            temp_archers[count] = i;
            c(count + 1, i + 1);

        }
    }

    static void go() {
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = init_board[i].clone();
        }
        int ans = 0;
        System.out.println("temp = " + Arrays.toString(temp_archers));
        for (int i = 0; i < n; i++) {
            print_board(board);
            int remove_en = attck();
            ans += remove_en;
            move_en(i);
        }
        System.out.println(ans);
        if (res < ans) res = ans;
    }

    private static void move_en(int cnt) {
        for (int i = n-1; i > 0; i--) {
            board[i] = board[i-1];
        }
//        Arrays.fill(board[0],0);
    }

    private static int attck() {
        int[][] delta = new int[][]{{0, -1}, {-1, 0}, {0, 1}};
        ArrayList<int[]> remove_en = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            // 죽일 적 찾는 로직
            isvisited = new boolean[n][m];
            Deque<int[]> q = new ArrayDeque<>();
            int[] archer_place = new int[]{n, temp_archers[i]};
            q.addFirst(archer_place);

            // 찾는 경우와 못 찾는 경우가 있음.
            loop:
            while (!q.isEmpty()) {
                // 이래야 FiFo
                int[] poll = q.pollFirst();
                int y = poll[0];
                int x = poll[1];
                System.out.println(y +" " + x);
                for (int j = 0; j < 3; j++) {
                    int dy = y + delta[j][0];
                    int dx = x + delta[j][1];
                    // 사이즈 체크, 적인지 확인, 거리 안인지 확인.
                    if (check_size(dy, dx) && board[dy][dx] == 1 && in_of_dis(new int[]{dy, dx}, archer_place)) {
                        for (int k = 0; k < remove_en.size(); k++) {
                            int[] ints = remove_en.get(k);
                            if (ints[0] == dy && ints[1] == dx){
                                break loop;
                            }
                        }
                        remove_en.add(new int[]{dy, dx});
                        break loop;
                    }
                    if (check_size(dy, dx) && !isvisited[dy][dx] && board[dy][dx] == 0 && in_of_dis(new int[]{dy, dx}, archer_place)) {
                        q.add(new int[] {dy, dx});
                        isvisited[dy][dx] = true;
                    }
                }
            }
        }
        // 죽은 적 카운트 + 없애주기}
        for (int[] ints : remove_en) {
            board[ints[0]][ints[1]] = 0;
            System.out.print(Arrays.toString(ints));
        }
        System.out.println();
        return remove_en.size();
    }


    static boolean in_of_dis(int[] en, int[] archer) {
        return Math.abs(en[1] - archer[1]) + Math.abs(en[0] - archer[0]) <= d;
    }

    static boolean check_size(int y, int x) {
        return 0 <= x && 0 <= y && x < m && y < n;
    }

    static void print_board(int[][] board) {
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}

