import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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
}

