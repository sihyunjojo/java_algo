import java.io.FileInputStream;
import java.io.*;
import java.util.*;

// 재귀에서 time을 time에 따라서 함수들의 순서를 어떻게 구현하고 안에 time인자가 들어가야하는 부분을 어떻게 설정해야할지에 대해서 고민이 조금 더 필요함.

public class Solution {
    static class Edge{
        // to는 항상 자기 자신? 자기자신에서 출발하는게 맞으니까.
        // to를 루트노드로 생각하면 되지 않을까??
        int to;
        int from;
        int index;

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

            Deque<Integer> q = new ArrayDeque<>();
            edges = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < data_len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(to, from, from);
                edges.add(edge);
            }

            q.addFirst(start_point);
            int res = start_point;

            // 그냥 없으면 자기가 젤 큼.
//            if (q.isEmpty()) System.out.println(res);

            // 전화 받은 사람 중 가장 숫자가 큰 사람을 출력
            while (!q.isEmpty()){
                Integer now = q.pollLast();

                for (int i = 0 ; i < edges.size(); i++){
                    Edge to_edge = edges.get(i);
                    if (to_edge.from == now){
                        q.addFirst(to_edge.to);

                        // 내 생각엔 이게 문제야.
//                        to_edge.from = start_point;

                        if (res < to_edge.index) res = to_edge.index;
                    }
                }

                // 2 -> 7 // 7 - 2 ///// 7 -> 1 // 1 -> 2
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    static boolean union(Edge e1, Edge e2){
         if (e1.from == e2.from){
             return false;
         }
         e2.from = e1.from;
         return true;
    }
}

