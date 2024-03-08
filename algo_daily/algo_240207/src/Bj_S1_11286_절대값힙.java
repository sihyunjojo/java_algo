import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 잘 하면 됨.
public class Bj_S1_11286_절대값힙 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            } return o1[0] - o2[0];
        });

        for (int i =0; i < n; i++){
            for (int[] ints : pq) {
                System.out.printf(ints[1]+" ");
            }
            System.out.println();
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if (pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(pq.poll()[1]).append("\n");
                continue;
            }
            pq.add(new int[] {Math.abs(num),num});
        }
        System.out.println(sb);
    }
}