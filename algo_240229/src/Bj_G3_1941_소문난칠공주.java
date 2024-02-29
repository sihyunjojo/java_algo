import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Bj_G3_1941_소문난칠공주 {
    static class Person{
        int x,y,index;

        public Person(int y, int x) {
            this.x = x;
            this.y = y;
            this.index = 10 * y + x;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "x=" + x +
                    ", y=" + y +
                    ", index=" + index +
                    '}';
        }
    }
    static char[][] board;
    static boolean[] isvisited;
    static int[] personList,xs,ys;
    static int res;
    static ArrayList<Person> idasom, imdoyeon;
    static int[][] delta = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        idasom = new ArrayList<>();
//        imdoyeon = new ArrayList<>();
        board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }


        // 이다솜파 4명을 끼우고 그다음을 아무나 끼우면 되잖아.
//        for (int i = 4; i < 7; i++) {
//            combination(0,0,i);
//        }

        xs = new int[25];
        ys = new int[25];

        for (int i = 0; i < 25; i++){
            xs[i] = i % 5;
            ys[i] = i / 5;
        }

        personList = new int[7];

        combination(0,0);
        System.out.println(res);
    }

    static void combination(int count, int start){
        if (count == 7){
            bfs();
            return;
        }
        for (int i = start; i < 25; i++){
            personList[count] = i;
            combination(count+1,i+1);
        }
    }

    static void bfs() {
        int dasom_cnt = 0;
        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque();
        isvisited = new boolean[7];

        q.add(0);


        while (!q.isEmpty()){
            int poll = q.poll();
            int y = ys[personList[poll]];
            int x = xs[personList[poll]];
            for (int d = 0; d < 4; d++){
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];

                if (check_size(dy,dx)){
                    int next = dx + (dy * 5);

                    for (int i = 0; i < 7; i++){
                        if (personList[i] == next){
                            if (!isvisited[i]){
                                isvisited[i] = true;
                                q.add(i);
                                cnt++;
                                if (board[dy][dx] == 'S'){
                                    dasom_cnt++;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (cnt == 7 && dasom_cnt > 3){
            res++;
        }
    }

    static boolean check_size(int y, int x) {
        return 0 <= y && y < 5 && 0 <= x && x < 5;
    }
}


