package solved;

import java.io.FileInputStream;
import java.io.*;
import java.util.*;

// 재귀에서 time을 time에 따라서 함수들의 순서를 어떻게 구현하고 안에 time인자가 들어가야하는 부분을 어떻게 설정해야할지에 대해서 고민이 조금 더 필요함.

public class Swea_d4_1238_Contact {
    static class Edge{
        // to는 항상 자기 자신? 자기자신에서 출발하는게 맞으니까.
        // to를 루트노드로 생각하면 되지 않을까??
        int to;
        int from;
        int index;
        int depth;

        public Edge(int to, int from, int index) {
            this.to = to;
            this.from = from;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", from=" + from +
                    ", index=" + index +
                    '}';
        }
    }
    static List<Edge> edges;
    static int start_point;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int data_len = Integer.parseInt(st.nextToken());
            start_point = Integer.parseInt(st.nextToken());

            int res = start_point;
            int res_depth = 0;

            ArrayList<Integer>[] arr = new ArrayList[100+1];
            for (int i = 0; i < 101; i++){
                arr[i] = new ArrayList<>();
            }

            boolean[] isvisited = new boolean[101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < data_len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from].add(to);
            }

            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[] {start_point,0});
            isvisited[start_point] = true;

            while (!q.isEmpty()){
                int[] now = q.poll();

                for (int a : arr[now[0]]){
                    if (isvisited[a]) continue;
                    isvisited[a] = true;
                    q.add(new int[] {a, now[1] + 1} );

                    if (res_depth < now[1]+1) {res = a; res_depth = now[1]+1;}
                    if (res_depth == now[1]+1 && res < a) {res = a;}

                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
//24 2
//2 7 11  6  6  2  2  15  15  4  4  2  4  10 7  1  1  7  1  8  1  17  3  22
