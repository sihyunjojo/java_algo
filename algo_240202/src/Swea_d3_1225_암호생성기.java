import java.io.*;
import java.util.*;

public class Swea_d3_1225_암호생성기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input6.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> arr = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++){
                arr.add(Integer.valueOf(st.nextToken()));
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
