import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int n, k, underLine;
    static int[][] delta = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }
        int time = 0;
        while (checkFinish()) {
            underLine = n;
            time++;
            solve();
        }


        System.out.println(time);
    }


    static void solve() {
        init();
        print();
        int a = 0;
        while (moveUp() && a < 3) {
            a++;
        }
        moveFish();
        moveLine();
        moveHarp();
        moveFish();
        moveLine();
    }

    static void init() {
        ArrayDeque<Integer> integers = minFish();
        for (Integer integer : integers) {
            arr[0][integer]++;
        }

        arr[1][0] = arr[0][0];
        for (int i = 0; i < n-1; i++) {
            arr[0][i] = arr[0][i+1];
        }
        arr[0][n-1] = 0;

    }

    static ArrayDeque<Integer> minFish() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > arr[0][i]) {
                min = arr[0][i];
                list.clear();
            }
            if (min == arr[0][i]) {
                list.add(i);
            }
        }
        System.out.println(list);
        return list;
    }

    static boolean moveUp() {
        int tmp = 0;
        for (int i = 0; i < underLine; i++) {
            if (arr[1][i] == 0) {
                break;
            }
            tmp = i;
        }

        System.out.println("tmp : " + tmp);

        int maxHeight = 0;
        for (int i = 0; i <= tmp; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][tmp] == 0){
                    break;
                }
                if (maxHeight < j){
                    maxHeight = j;
                }
            }
        }
        System.out.println("maxHeight: " + maxHeight);

        if (2 * (maxHeight + 1) > underLine){
            return false;
        }

        int[][] tmp_board = new int[n][n];

        // y
        for (int i = 0; i <= maxHeight; i++) {
            // x
            for (int j = 0; j <= tmp; j++) {
                tmp_board[maxHeight-j-1][i] = arr[i][j];
//                arr[maxHeight-j][i] = arr[i][j];
            }
        }

        for (int[] ints : tmp_board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();

        for (int i = 1; i <= tmp; i++) {
            // x
            for (int j = 0; j <= maxHeight; j++) {
                arr[maxHeight+i][j] = tmp_board[i][j];
            }
        }


        for (int i = tmp+1; i < underLine; i++) {
            arr[0][i-tmp-1] = arr[0][i];
        }

        underLine -= tmp;

        print();
        return true;
    }

    static void moveFish() {
        int[][] tmpBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int dy = i + delta[d][0];
                    int dx = j + delta[d][1];
                    if (!checkSize(dy,dx)) continue;
                    if (arr[dy][dx] == 0) continue;
//                    System.out.println(i + " " + j + " " + arr[i][j]);
//                    System.out.println("d " + dy + " "+ dx + " " + arr[dy][dx]);
                    if (arr[i][j] > arr[dy][dx]){
                        int mock = arr[i][j] / 5;
                        if (mock > 0){
                            tmpBoard[dy][dx] += mock;
                            tmpBoard[i][j] -= mock;
                        }
                    }
                }
            }
        }

        for (int[] ints : tmpBoard) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += tmpBoard[i][j];
            }
        }
//        arr = tmpBoard;
        print();
    }

    static void moveLine() {
        int tmp = 0;

        int[][] tmpBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                tmpBoard[0][tmp++] = arr[i][j];
            }
        }
        arr = tmpBoard;
    }

    static void moveHarp() {
        int moveLine = n / 2;
        for (int i = 0; i < moveLine; i++) {
            arr[1][i] = arr[0][i];
            arr[0][i] = arr[0][i+moveLine];
        }

        moveLine /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < moveLine; j++) {
                arr[2+j][i] = arr[i][j];
                arr[i][j] = arr[i][j+2];
            }
        }
    }

    static boolean checkFinish() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < arr[0][i]) {
                max = arr[0][i];
            }
            if (min > arr[0][i]) {
                min = arr[0][i];
            }
        }
        return (max - min) > k;
    }

    static boolean checkSize(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    static void print(){
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}