import java.io.*;
import java.util.*;

// 탑
// 시간초과
// 루프 사용 방법 있음.
public class Bj_G5_2493_탑_TimeE {
    static StringBuilder sb = new StringBuilder();
    static int n, tower_heis[];
    public static void main(String[] args) throws IOException {
        // n개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tower_heis = new int[n];
//        SortedSet <Integer> hei = new TreeSet<>();

        loop:
        for (int i = 0; i < n; i++){
            tower_heis[i] = Integer.parseInt(st.nextToken());
            for (int j = i-1; j > 0; j--){
                if (tower_heis[i] < tower_heis[j]){
                    sb.append(j+1).append(" ");
                    continue loop;
                }
            }
            sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}