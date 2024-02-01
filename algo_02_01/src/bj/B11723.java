package bj;

import java.io.*;
import java.util.*;

// 비트마스킹으로 풀기
public class B11723 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("add")){

                }if (command.equals("remove")){

                }if (command.equals("check")){

                }if (command.equals("toggle")){

                }
            }

        }
    }
}
