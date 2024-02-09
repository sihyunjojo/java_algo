package fail.answer;

import java.io.*;
import java.util.*;

// 탑
// dp?
// 이전보다 크면 = 같은거 보내주고
// 이전보다 작으면 = 방금껄로 바꿔주고
// 답지 봤음.
// 외우기
public class Bj_G5_2493_탑_Answer {
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

        // 정렬이 가능한 자료구조 : list,stack,deque
        int[] dp = new int[n];
        Deque<int[]> result = new ArrayDeque<>();
//        tower_heis[0] = Integer.parseInt(st.nextToken());
//        result.push(new int[] {0,0});
//        sb.append(0);

        for (int i = 1; i <= n; i++){
            int top = Integer.parseInt(st.nextToken());
            while(!result.isEmpty()) {
                if (result.peek()[1] > top) {
                    sb.append(result.peek()[0]).append(" ");
                    break;
                }
                result.pop();
            }
            if (result.isEmpty()){
                sb.append(0+" ");
            }
            result.push(new int[] {i,top});
        }
        System.out.print(sb);
    }
}

//10
//6 1 8 5 9 2 4 3 7 10
