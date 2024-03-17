import javax.swing.text.html.ListView;
import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 너무너무너무너무너무 어려움
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

<<<<<<< Updated upstream
        LinkedList<Integer> arr = new LinkedList<>();

        // 1,2,3,4,5 ~
//        for (int i = n; i > 0; i--){
//            arr.add(i);
//        }

        System.out.println(arr);

        int one_index = 0;
        int two_index = 1;
        int last_index = n-1;

        for (int i = n; i > 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    arr.set(one_index,i);
                    one_index++;
                    two_index++;
                    break;
                case 2:
                    arr.set(two_index,i);
                    two_index++;
                    break;
                default:
                    arr.set(last_index,i);
                    last_index--;
=======
        int[] arr = new int[n];

        int last = n-1;
        int first = 0;
        int second = 1;

        for (int i = n; i >= 1; i--) {
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    arr[first] = i;
                    second++;
                    first = second-1;
                    break;
                case 2:
                    arr[second] = i;
                    second++;
                    break;
                default:
                    arr[last] = i;
                    last--;
>>>>>>> Stashed changes
                    break;
            }
//            System.out.println(list);
        }
        System.out.println(arr);

        // 한칸씩 다 밀림

        // 1의 경우도 ++
        // 대신 2도 ++ 해줘야함.

        // 2의 경우는
        // 2번째 넣은거 ++
        // 3은 바닥에서 --
        // 1은

//        1,2,3,4,5

        // 2 3 3 2 1 을 했다.
        // 그럼 (위) 1 5 2 3 4 가 순서대로 나온다.
        // 바닥 -> 맨 위
        // 바닥 -> 맨 위서 2번째
        // 바닥 -> 바닥

        // 1 5 2 3 4

        // 1 2 3 3 2

        // 1 2 3 4 5

        // 5 4 3 2 1
        // 1 1 1 1 1

        //

        // 5 4 3 2 1
        // 2 3 3 2 1

        //    5 4
        // 1 2 3 4 5
        // 1 2 3 3 2

        // 1 2 5 3 4

//        index 위치 기억?

        //  1  5  2  3  4
        //   5  2  3  4


        StringBuilder sb = new StringBuilder();

        for (int i= 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}

