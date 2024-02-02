import java.io.*;
import java.util.*;

//  메모리 제한이 4메가 이므로 비트마스킹으로 풀어야할 가능성이 크다.
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.charAt(0) - '0';
        int k = s.charAt(2) - '0';

        int[] arr = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        int count = 0;
        int tmp = 0;

        bw.write("<");
        for (int i = 0; i < n; i++){
            count += k;
            while(count >= n){
                count = count % n;
            }
            result[i] = arr[count];
            System.out.println(arr[count]);
//            bw.write(arr[count-tmp]+", ");
        }
        bw.write(">");
    }
}