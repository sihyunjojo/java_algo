import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int min, max;
    static StringBuilder sb = new StringBuilder();
    static int[] temp = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = calHolsu(s);
        max = n;
        min = n;
        solve(s);
        System.out.println(min + " " + max);
    }

    static void solve(String s) {
        while (s.length() > 1) {
            if (s.length() == 2) {
                s = isLenTwo(s);
            }
            else {
                s = isLenUpTwo(s);
            }
            int cnt = calHolsu(s);
            if (cnt > max) max = cnt;
            if (cnt < min) min = cnt;
        }
    }

    static void Combi(int num) {
        temp
    }

    static String isLenTwo(String s) {
        int first = Integer.parseInt(String.valueOf(s.charAt(0)));
        int second = Integer.parseInt(String.valueOf(s.charAt(1)));
        return String.valueOf(first + second);
    }

    static int calHolsu(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((Integer.parseInt(String.valueOf(s.charAt(i))) % 2) == 1) {
                cnt++;
            }
        }
        return cnt;
    }


}