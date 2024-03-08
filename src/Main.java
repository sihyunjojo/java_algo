import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
<<<<<<< HEAD
    static class Fish{
        int x,y,index,dir;

        public Fish(int y, int x, int index, int dir) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.dir = dir;
        }
    }
    static int[] arr;
    static int n,m,res;
    static Fish[][] board;
    static int[][] delta = new int[][] {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    static PriorityQueue<Fish> fishs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new Fish[4][4];
        fishs = new PriorityQueue<>(Comparator.comparingInt(f -> f.index));
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

        res = 0;
        // y,x,sum(index)
        go(0,0, board[0][0].dir, board[0][0].index);
        dfs(0,0, board[0][0].dir, board[0][0].index);

        System.out.println(res);
    }
    static void move_fishs(){
        for (Fish fish : fishs) {
            move_fish(fish);
        }
    }
    // 물고기 이동
    static void move_fish(Fish fish){
        int dy = fish.y;
        int dx = fish.x;
        int dir = fish.dir;

        loop:
        for (int i = 0; i < 8; i++) {
            dir = (fish.dir++) % 8;

            int move_y = delta[dir][0];
            int move_x = delta[dir][1];

            dy += move_y;
            dx += move_x;

            // 다른 거라도 하는게 이득이므로 그냥 return해줘도 됨.
            if (board[dy][dx] == null) break loop;
            if (board[dy][dx].index > 0) break loop;

            if(i == 7){
                return;
            }

            dy = fish.y;
            dx = fish.x;
        }

        Fish fish1 = board[dy][dx];
        fish1.y = fish.y;
        fish1.x = fish.x;

        board[fish.y][fish.x] = fish1;

        fish.y = dy;
        fish.x = dx;
        fish.dir = dir;

        board[dy][dx] = fish;

    }
    // 상어 이동
    static void dfs(int y, int x, int dir, int ans){
        // 갈 곳이 없으면
        int move_y = delta[dir][0];
        int move_x = delta[dir][1];

        int dy = y + move_y;
        int dx = x + move_x;

        while (!check_size(dy,dx)){
            // 다른 거라도 하는게 이득이므로 그냥 return해줘도 됨.
            if (board[dy][dx] == null) return;
            Fish tmp_fish = board[dy][dx];

            board[dy][dx] = null;
            dfs(dy, dx, board[dy][dx].dir, ans + board[dy][dx].index);
            board[dy][dx] = tmp_fish;

            dy += move_y;
            dx += move_x;
        }
    }

    static boolean check_size(int y, int x){
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }


=======
   static class Node {
      int from,to,w;

      public Node(int from, int to, int w) {
         this.from = from;
         this.to = to;
         this.w = w;
      }
   }
   static StringBuilder sb = new StringBuilder();
   static int v,e;
   static long res;
   static ArrayList<int[]>[] arr;


   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine());

       v = Integer.parseInt(st.nextToken());
       e = Integer.parseInt(st.nextToken());

       arr = new ArrayList[v+1];

      for (int i = 0; i < v+1; i++) {
         arr[i] = new ArrayList<>();
      }


      int from = 0;
       for (int i = 0; i < e; i++){
          st = new StringTokenizer(br.readLine());
          from = Integer.parseInt(st.nextToken());
          int to = Integer.parseInt(st.nextToken());
          int w = Integer.parseInt(st.nextToken());
          arr[from].add(new int[] {to,w});
          arr[to].add(new int[] {from,w});
       }

      res = 0;
      boolean[] isvisited = new boolean[v+1];

      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
      pq.offer(new int[] {from, 0});

      while (!pq.isEmpty()){
         int[] poll = pq.poll();

          if(isvisited[poll[0]]) continue;
          isvisited[poll[0]] = true;
          res += poll[1];

          for (int[] e : arr[poll[0]]) {
              if(isvisited[e[0]]) continue;
              pq.add(e);
          }
      }
       System.out.println(res);
   }
>>>>>>> 55be9c293e926c5768eb372199fc4449c47aef8c
}

