import java.io.*;
import java.util.*;

public class Main {
    static class Queen {
        int x, y, minus, plus, index, in;

        public Queen(int x, int y,int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.minus = x - y + n-1;
            this.plus = x + y;
        }

        @Override
        public String toString() {
            return "Queen{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int[][] board, tempBoard;
    static int n,res1,res2;
    static ArrayList<Queen> list1,list2,now_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        tempBoard = new int[n][n];
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        now_list = new ArrayList<>();
        int cnt = 0;

        int index = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    Queen queen = new Queen(j, i, ++index);
                    if ((i+j) % 2 == 0){
                        list1.add(queen);
                    } else {
                        list2.add(queen);
                    }
                }
            }
        }
    }


    static boolean checkThis(Queen q) {
        for (Queen queen : now_list) {
            if (queen.minus == q.minus) return false;
            if (queen.plus == q.plus) return false;
        }
        return true;
    }

    static void copyBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
    }
}