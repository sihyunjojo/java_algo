import java.io.*;
import java.util.*;

// String으로 선언한 후 하나씩 접근하는 방법
public class Swea_d3_1228_암호문1 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input1228.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> origin = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                origin.add(Integer.valueOf(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int commend_n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int flag = 0, x=0, y=0;
            for (int i = 0; i < commend_n;){
                String s = st.nextToken();
                if (s.equals("I")){
                    i++;
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++){
                        origin.add(x++, Integer.parseInt(st.nextToken()));
                    }
                }
            }

            sb.append("#").append(tc);
            for (int i = 0; i < 10; i++){
                sb.append(" ").append(origin.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
