import java.io.FileInputStream;
import java.io.*;
import java.util.*;

// 재귀에서 time을 time에 따라서 함수들의 순서를 어떻게 구현하고 안에 time인자가 들어가야하는 부분을 어떻게 설정해야할지에 대해서 고민이 조금 더 필요함.

public class Swea_5653_줄기세포배양 {
    static class Cell {
        int x;
        int y;
        int value;
        int init_time;

        public Cell(int value, int init_time) {
            this.value = value;
            this.init_time = init_time;
        }

        public Cell(int x, int y, int value, int init_time) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.init_time = init_time;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    ", init_time=" + init_time +
                    '}';
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int[][] delta = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] board;
    static int k,time;
    static List<Cell> not_die_cell;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input5653.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n + (2 * k)][m + (2 * k)];
            not_die_cell = new ArrayList<>();

            for (int i = k; i < n + k; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = k; j < m + k; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value != 0) {
                        Cell temp_cell = new Cell(j, i, value, 1);
                        board[i][j] = temp_cell.value;
                        not_die_cell.add(temp_cell);
                    }
                }
            }

            time = 0;
            while (time < k) {
                time++;
                go();
//                System.out.println(time +"시간 후");
//                print_board();
//                print_not_die();
            }
            sb.append(not_die_cell.size()).append("\n");
        }
        System.out.println(sb);
    }

    static void go() {
        not_die_cell.sort((o1, o2) -> {
            return -(o1.value - o2.value);
        });

        for (int i = 0; i < not_die_cell.size(); i++) {
            Cell temp_cell = not_die_cell.get(i);
            if (check_active(temp_cell)) {
                glow(temp_cell);
            }
        }

        // 내 코드에선 마지막에서 해줘야함.
        out();
    }

    // 처음에 리스트에 다 넣어주고
    // 이후에 추가 된값들 리스트에 넣어주면서
    // c.init_time + c.value <= k && c.init_time+ c.value + c.value >= k
    // 위에 조건식으로 걸러주면서 하면 되나??
    // 그 이후에 sort로 count부터 오름차순 정렬해줘서 // 헤야하나??

    static void glow(Cell cell) {
        for (int d = 0; d < 4; d++) {
            int dy = cell.y + delta[d][0];
            int dx = cell.x + delta[d][1];
            if (board[dy][dx] < cell.value && board[dy][dx] == 0) {
//                System.out.println(dx+" "+ dy);
                Cell new_cell = new Cell(dx, dy, cell.value, time+1);
                board[dy][dx] = new_cell.value; // ???
                not_die_cell.add(new_cell); //  넣자마자는 비활성화니까 넣어줌.
            }
        }
    }

    // 정확하지 않음.
    static boolean check_active(Cell c) { // 리스트에서 활성화인 것만 처리해주는 코드. (비활성화는 우선 나둠)
        return c.init_time + c.value <= time && time < c.init_time + c.value + c.value ;

        // 0 + 1 >= 1 && 0 + 1 + 1 > 1;
        // 0 + 2 >= 2 && 0 + 2 + 2 < 4;  // 2 3
        // k <= 3 + 2 && 3 + 2 + 2 < k
    }

    static void out() { // 리스트에서 죽은 세포 빼주는 코드.
        for (int i = 0; i < not_die_cell.size(); i++){
            Cell cell = not_die_cell.get(i);
            if (check_die(cell)){
                not_die_cell.remove(i);
                i--;
            }
        }
    }

    static boolean check_die(Cell cell){
        return time == cell.init_time + cell.value + cell.value - 1;
    }

    static void print_not_die(){
        for (Cell cell : not_die_cell) {
            System.out.print(cell.value+" ");
        }
        System.out.println();
    }

    static void print_board(){
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
//        for (int i = board.length-1; i > 0; i--) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        System.out.println();
    }
}
