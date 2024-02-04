import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer(new StringBuffer());

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int n = 600000;
        int k = 10;
        Func fun = () -> {
            int count = 0;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                a.add(i);
            }
//            bw.write("<");
            sb.append("<");
            for (int i = 1; i <= n; i++) {
                count = (count + k - 1) % a.size();
                sb.append(a.get(count));
//                bw.write(String.valueOf(a.get(count)));
                a.remove(count);
//                bw.write(i != n ? ", " : ">");
                sb.append(i != n ? ", " : ">");
            }
        };
//            bw.flush();
            System.out.println(sb);

        Measure_time.runFunction(fun);
    }
}
// 2742
// 5000
// 5223
// 5030

// 4000
// 4373

//30000
//29580
//28585

// 20000
//28417
//28683


// 1.38
// 1.36
// 1.36
// 1.36
// 1.36

// 1.35

// 12.19
// 12.13
// 12.29

// 13.35