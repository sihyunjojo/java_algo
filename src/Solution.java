import java.io.*;
import java.util.*;

// String으로 선언한 후 하나씩 접근하는 방법
public class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input6.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> arr = new ArrayDeque<>();
            int min_value = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++){
                arr.add(Integer.valueOf(st.nextToken()));
            }

            // 8번 씩 돌릴떄마다 다 같은 수가 빠진다를 이용하면 될거 같다.
            for (int i = 0; i< 8; i++){
                arr.offerLast( arr.pollFirst() - min_value);
            }

            int num = 0, tmp = 0;
            while (true){
                num = (num % 5) + 1;
                tmp = arr.pollFirst() - num;
                if (tmp <= 0){
//                    tmp = 0;
//                    arr.offerLast(tmp);
                    arr.offerLast(0);
                    break;
                }
                arr.offerLast(tmp);
            }
            sb.append("#").append(t);
            for (int i = 0; i < 8; i++){
                sb.append(" ").append(arr.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
