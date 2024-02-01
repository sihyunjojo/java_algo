import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int s_len = Integer.parseInt(st.nextToken());
        int p_len = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[][] counts = new int[][] {{'A',0},{'C',0},{'G',0},{'T',0}};

        for (int i = 0; i < 4; i++) {
           counts[i][1] = Integer.parseInt(st.nextToken());
        }

//        char[] temp = Arrays.copyOfRange(arr, 0 , p_len);

        loop:
        for (int i = 0; i < s_len - p_len + 1; i++){
            int[] tmp = new int[4];
            char[] temp = new char[p_len];
            System.arraycopy(arr, i , temp,0,p_len);
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < p_len; k++){
                    if (temp[k] == counts[j][0]){
                        tmp[j] += 1;
                    }
                }
                if (tmp[j] < counts[j][1]){
//                    System.out.println(j + " "+ counts[j][0] +" "+ counts[j][1]+" "+ tmp[j] +" " + Arrays.toString(temp));
                    continue loop;
                }
            }
            result += 1;
//            System.out.println(Arrays.toString(temp));
        }
        System.out.println(result);
    }
}
