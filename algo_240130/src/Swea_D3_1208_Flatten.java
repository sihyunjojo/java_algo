import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("./input1.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            Integer[] board = new Integer[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++){
                board[i] = Integer.parseInt(st.nextToken());
            }
            Integer[] sorted_max= Arrays.copyOf(board, 100);
            Arrays.sort(sorted_max);


            while (dump != 0){
                sorted_max[0] += 1;
                sorted_max[99] -= 1;
                dump -= 1;
                Arrays.sort(sorted_max);
            }

            System.out.printf("#%d %d\n",tc,sorted_max[99]-sorted_max[0]);

        }
    }
}
