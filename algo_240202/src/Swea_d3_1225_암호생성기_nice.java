import java.io.*;
import java.util.*;

// 어레이덱 자료구조
// 6배 이상 빠름.
public class Swea_d3_1225_암호생성기_nice {
    static StringBuilder sb = new StringBuilder();
    static final int ONE_CICLE= (15 * 8);
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1225.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> arr = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int min_value = Integer.MAX_VALUE;
            for (int i = 0; i < 8; i++){
                arr.add(Integer.valueOf(st.nextToken()));
                if (min_value > arr.getFirst()) min_value = arr.getFirst();
            }

            // 8번 씩 돌릴떄마다 다 같은 수가 빠진다를 이용하면 될거 같다.
            for (int i = 0; i< 8; i++){
                arr.offerLast(arr.pollFirst() - (min_value - (min_value % ONE_CICLE)));
            }

            int num = 0, tmp = 0;
            while (true){
                num = (num % 5) + 1;
                tmp = arr.pollFirst() - num;
                if (tmp <= 0){
                    arr.offerLast(0);
                    break;
                }
                arr.offerLast(tmp);
            }

            System.out.println(arr);
            sb.append("#").append(t);
            for (int i = 0; i < 8; i++){
                sb.append(" ").append(arr.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

