import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어떠한 동전들의 조합으로도 정확한 물건값이 될 수 없는 경우는 입력으로 주어지지 않는다.
// 그럼 뒤에서 부터 최대한 넣어주면 되지 않을까??

// 반복문을 뒤에서 생각하는 것 뿐만아니라.
// 전체의 결과가 있다면, 그 것을 반대로 구해서 마지막에 살짝만 계산하면 되는게 있다.

public class J_G4_1828_냉장고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1,o2) -> {
            if (o1[0]==o2[0]){
                return o1[1] - o2[1];
            } return o1[0] - o2[0];
        });

        int cnt = 0;
//        for (int[] ints : arr) {
//            System.out.println(cnt++ + " "+ Arrays.toString(ints));
//        }

        int result = 1;
        int temp = arr[0][0];
        int temp2 = arr[0][1];

        for (int i = 1; i < n; i++){
            if (temp2 > arr[i][1]){
                temp2 = arr[i][1];
            }
            if (arr[i][0] > temp2){
//                System.out.println(i);
//                System.out.println(arr[i][0]);
//                System.out.println(temp2);
                temp2 = arr[i][1];
                result++;
            }
        }
        System.out.println(result);



    }
}