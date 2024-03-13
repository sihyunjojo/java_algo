import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish {
        int x, y, index, dir;

        public Fish(int y, int x, int index, int dir) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "x=" + x +
                    ", y=" + y +
                    ", index=" + index +
                    ", dir=" + dir +
                    '}';
        }
    }

    static int res;
    static int[][] delta = new int[][]{{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static List<Fish> fishs;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Fish[][] board = new Fish[4][4];
        fishs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int index = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(i, j, index, dir);

                fishs.add(fish);
                board[i][j] = fish;
            }
        }

        res = board[0][0].index;
        // y,x,sum(index)
        Fish zero_fish = board[0][0];
        board[0][0] = new Fish(0, 0, 0, zero_fish.dir);
        fishs.remove(zero_fish);
        dfs(0, 0, zero_fish.dir, zero_fish.index, board);

        System.out.println(res);
    }

    static void move_fishs(Fish[][] board) {
        fishs.sort(Comparator.comparingInt(f -> f.index));
        System.out.println("fishs" + fishs);
        for (Fish fish : fishs) {
            move_fish(fish, board);
        }
    }

    // 물고기 이동
    static void move_fish(Fish fish, Fish[][] board) {
        for (int i = 0; i < 8; i++) {
            int dir = (fish.dir + i);
            if (dir > 8) dir -= 8;

            int move_y = delta[dir][0];
            int move_x = delta[dir][1];

            int dy = fish.y + move_y;
            int dx = fish.x + move_x;

            if (!check_size(dy, dx)) continue;
//            if(board[dy][dx].index == 0) continue;

            // 다른 거라도 하는게 이득이므로 그냥 return해줘도 됨.
            // 다른 물고기가 있거나 비어 있으면
            if (board[dy][dx] == null || board[dy][dx].index > 0) {
//                System.out.println(fish);
//                print_fishs();
//                System.out.println();
                swap_fish(new int[]{fish.y, fish.x}, new int[]{dy, dx},board );
                fish.dir = dir;
                fish.x = dx;
                fish.y = dy;
                return;
            }
        }
    }

    static void swap_fish(int[] now_fish, int[] another_fish, Fish[][] board) {
        Fish tmp_fish = board[now_fish[0]][now_fish[1]];
        Fish ano_fish = board[another_fish[0]][another_fish[1]];

        if (board[another_fish[0]][another_fish[1]] != null) {
            // 기존 물고기 위치에 다른 물고기
            ano_fish.x = tmp_fish.x;
            ano_fish.y = tmp_fish.y;

            board[now_fish[0]][now_fish[1]] = board[another_fish[0]][another_fish[1]];
        } else {
            // 기존 물고기 위치에 없는 공간
            board[now_fish[0]][now_fish[1]] = null;
        }

        // 다른 물고기 위치로 옮겨주기
        board[another_fish[0]][another_fish[1]] = tmp_fish;
    }

    static void eat_fish(Fish shark, Fish another_fish, Fish[][] board) {
        board[shark.y][shark.x] = null;

        shark.dir = another_fish.dir;
        shark.x = another_fish.x;
        shark.y = another_fish.y;
        board[another_fish.y][another_fish.x] = shark;
    }

    // 상어 이동
    static void dfs(int y, int x, int dir, int ans, Fish[][] init_board) {
        Fish[][] board = init_board;

        System.out.println("after eat next");
        print_fishs(board);
        move_fishs(board);
        System.out.println("after move");
        print_fishs(board);

        // 갈 곳이 없으면
        int move_y = delta[dir][0];
        int move_x = delta[dir][1];

        int dy = y + move_y;
        int dx = x + move_x;

        int cnt = 0;
        while (check_size(dy, dx)) {
            // 다른 거라도 하는게 이득이므로 그냥 return해줘도 됨.
            if (board[dy][dx] == null) continue;
            Fish tmp_fish = board[dy][dx];
            Fish shark = board[y][x];
            // 상어 이동

            fishs.remove(tmp_fish);
            eat_fish(shark, tmp_fish, board);

            dfs(dy, dx, tmp_fish.dir, ans + tmp_fish.index,board);

            print_fishs(init_board);
            print_fishs(board);
            System.out.println("원복");
            for (int i = 0; i < 4; i++) {
                board[i] = init_board[i];
            }
            fishs.add(tmp_fish);


            dy += move_y;
            dx += move_x;

            // 기저 조건
            cnt++;
        }

        if (cnt == 0) {
            if (res < ans) {
                System.out.println("ans =" + ans);
                res = ans;
            }
        }

    }

    static boolean check_size(int y, int x) {
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }

    static void print_fishs(Fish[][] board) {
        for (Fish[] fish : board) {
            System.out.println(Arrays.toString(fish));
        }
        System.out.println();
    }

}

