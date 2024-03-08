import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 자료구조 ArrayList
public class Bj_S4_1158_요세푸스문제 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer(new StringBuffer());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), count = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }
//        bw.write("<");
            sb.append("<");
        for (int i = 1; i <= n; i++) {
            count = (count + k - 1) % a.size();
                sb.append(a.get(count));
//            bw.write(Integer.toString(a.get(count)));
            a.remove(count);
//            bw.write(i != n ? ", " : ">");
                sb.append(i != n ? ", " : ">");
        }
//        bw.flush();
            System.out.println(sb);

    }
}