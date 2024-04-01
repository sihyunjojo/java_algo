import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Solution {
    static int n, r;
    static StringBuilder sb = new StringBuilder();
    static Deque<Long> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input5656.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            //  n C r 을 mod 한 값을 출력

            q = new ArrayDeque<>();
            go(2,3);
            q.add(1L);
            for (Long l : q) {
                System.out.println(l);
            }
//            int a = go(r,1);
//            int b = go(n,1);
//            int c = go(r-n,1);


        }
    }
    static void go (int now, int index){
        if (now == 1){
            return;
        }
        q.add((long) now);
        go((now * index) % 1234567891, ++index);
    }
}