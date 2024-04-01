<<<<<<< HEAD
import java.io.*;
import java.lang.reflect.Array;
=======
import javax.swing.text.html.ListView;
import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
>>>>>>> 44c6335a952afee22bc7de10b8a8885def246049
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
<<<<<<< HEAD

        int n= Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] arr = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            arr[from].add(new int[] {dis, to});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dis = new int[n+1];
        int[] last_points = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[] {0, start});

        loop:
        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            int now_dis = poll[0];
            int now = poll[1];

            if(now_dis > dis[now]) continue;

            for (int[] ints : arr[now]) {
                int next_dis = ints[0];
                int next = ints[1];
                if (dis[next] > now_dis + next_dis){
                    dis[next] = now_dis + next_dis;
                    last_points[next] = now;
                    pq.add(new int[] {dis[next], next});
                }
            }
        }

        int tmp = end;
        Deque<Integer> temp = new ArrayDeque<>();
        temp.add(end);
        while (tmp != start){
            tmp= last_points[tmp];
            temp.offerFirst(tmp);
        }
        System.out.println(dis[end]);
        System.out.println(temp.size());
        for (Integer i : temp) {
            System.out.print(i + " ");
        }
=======
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];
        list[0] = arr[0];

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (list[res] < arr[i]) {
                list[++res] = arr[i];
            }
        }

        System.out.println(res+1);
        for (int i = 0; i <= res; i++) {
            System.out.print(list[i] + " ");
        }


>>>>>>> 44c6335a952afee22bc7de10b8a8885def246049
    }
}