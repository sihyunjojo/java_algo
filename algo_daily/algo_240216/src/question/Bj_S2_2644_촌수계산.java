package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_S2_2644_촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new ArrayList[n+1];
        // 다 만들어 놓고 시작하는게 그냥 무조건 좋은 거 같은데??
        // 강사님한테 한번 물어도 보자.
        for (int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()); // 부모
            int from = Integer.parseInt(st.nextToken());
            arr[to].add(from);
            arr[from].add(to);
        }

        int res = -1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] isvisited = new boolean[n+1];

        q.add(new int[] {a,0});
        isvisited[a] = true;

        System.out.println(Arrays.toString(arr));

        // -1을 찾기위헤서 isvisited를 쓰는 방법보다 좋은 방식은 없나?
        loop:
        while(!q.isEmpty()){
            int[] poll = q.poll();

            for (int i = 0; i< arr[poll[0]].size(); i++){
                if (isvisited[arr[poll[0]].get(i)]) continue;
                if (arr[poll[0]].get(i) == b){
                    res = poll[1]+1;
                    break loop;
                }
                q.add(new int[] {arr[poll[0]].get(i), poll[1]+1});
                isvisited[arr[poll[0]].get(i)] = true;
//                System.out.println(Arrays.toString(q.element()));
            }

//            if (res < poll[1]) res = poll[1];
        }

//        q = new ArrayDeque<>();
//        q.add(new int[] {a,0});
//        while(!q.isEmpty()){
//            int[] poll = q.poll();
//            for (int i = 0; i< arr[poll[0]].size(); i++){
//                q.add(new int[] {arr[poll[0]].get(i),poll[1]+1});
//            }
//            System.out.println(q);
//            if (res < poll[1]) res = poll[1];
//        }

        System.out.println(res);
    }

    static void print_board(boolean[][] board){
        for (boolean[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
