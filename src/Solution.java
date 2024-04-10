import java.io.*;
<<<<<<< HEAD
import java.util.*;

public class Solution {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] delta = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    board[i][j] = s.charAt(j) - '0';
                }
            }

            boolean[][] isvisited = new boolean[n][n];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0,0));
            isvisited[0][0] = true;


            loop:
            while (!pq.isEmpty()) {
                Node now = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int y = now.y + delta[d][0];
                    int x = now.x + delta[d][1];
                    if (!checkSize(y, x)) continue;
                    if (isvisited[y][x]) continue;
                    isvisited[y][x] = true;
                    pq.add(new Node(x,y,board[y][x] + now.cost));

                    if (y == n - 1 && x == n - 1) {
                        sb.append(now.cost).append("\n");
                        break loop;
                    }
                }
            }
=======
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
    static int res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input5643.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append(" ");

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] arr = new ArrayList[n+1];
            ArrayList<Integer>[] arr1 = new ArrayList[n+1];

            for (int j = 0; j < n+1; j++) {
                arr[j] = new ArrayList<>();
                arr1[j] = new ArrayList<>();

            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr[from].add(to);
                arr1[to].add(from);
            }

            int res = 0;
            for (int j = 1; j < n+1; j++) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(j);
                int cnt = 1;
                
                boolean[] isvisited = new boolean[n+1];
                isvisited[j] = true;
                
                while (!q.isEmpty()){
                    Integer now = q.poll();

                    for (Integer next : arr[now]) {
                        if (isvisited[next]) continue;
                        q.add(next);
                        isvisited[next] = true;
                        cnt++;
                    }
                }

                q.add(j);

                while (!q.isEmpty()){
                    Integer now = q.poll();

                    for (Integer next : arr1[now]) {
                        if (isvisited[next]) continue;
                        q.add(next);
                        isvisited[next] = true;
                        cnt++;
                    }
                }
                if (cnt == n) res++;
            }
            sb.append(res).append("\n");
>>>>>>> a74331bfccf58df519906425910ce3752a0a4e3d
        }
        System.out.println(sb);
    }

<<<<<<< HEAD
    static boolean checkSize(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
=======
>>>>>>> a74331bfccf58df519906425910ce3752a0a4e3d
}