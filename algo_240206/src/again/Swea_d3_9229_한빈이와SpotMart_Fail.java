package again;

import java.io.*;
import java.util.*;

// 두 합이 하나의 값에 가까까운 값이 될때까지 찾는 문제
// 투 포인터?? 이진 탐색??
// 이진트리는 아닌 거 같은데 내가 부족해서 안 보이는 걸 수 도 있겠다.
public class Swea_d3_9229_한빈이와SpotMart_Fail {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 200 000

            List<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);

            int result = -1;

            int start = 0, end = n-1;
            while(start < end){
                if (arr.get(start) + arr.get(end) == m){
                    result = m;
                    break;
                }
                else if (arr.get(start) + arr.get(end) < m){
                    ++start;
                    if (arr.get(start) + arr.get(end) < m){
                        result = Math.max(result, arr.get(start) + arr.get(end));
                    }
                }
                else{
                    --end;
                    if (arr.get(start) + arr.get(end) < m){
                        result = Math.max(result, arr.get(start) + arr.get(end));
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
