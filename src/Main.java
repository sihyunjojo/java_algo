import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 어떠한 동전들의 조합으로도 정확한 물건값이 될 수 없는 경우는 입력으로 주어지지 않는다.
// 그럼 뒤에서 부터 최대한 넣어주면 되지 않을까??
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 되도록 많은 개수의 동전을 사용한다.
        // 정확한 돈을 넣어야한다.

        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[][] coins = new int[][] {{500,0},{100,0},{50,0},{10,0},{5,0},{1,0},};
        int[] result = new int[] {0,0,0,0,0,0};

        for (int i = 0; i < 6; i++){
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 5; i > 0; i--) {
            if (coins[i][1] == 0 || w == 0) continue;
            System.out.println("i" + i);
            // 딱 맞아 떨어지므로, 이 전의 나머지 만큼은 무조건 사용하게 되어 있음.
//            while(coins[i][1] >= coins[i-1][0] && coins[i][1] > 0){
            int charge = w % (coins[i - 1][0] / coins[i][0]);

            System.out.println("charge = " + charge);
            w -= w % coins[i - 1][0]; //총 가격빼기
            result[i] += charge ; // 내가 낸 돈 저장해두기
            coins[i][1] -= charge; // 내가 가지고 있는 돈 빼기System.out.printl;

//            for (int[] coin : coins) {
//                System.out.print(Arrays.toString(coin) +" ");
//            }
//            System.out.println(Arrays.toString(result));
//            System.out.println("w =" + w);


//            while (0 < coins[i][1] && coins[i][1] >= coins[i - 1][0] / coins[i][0]) {
//                System.out.println("go while");
//                System.out.println(coins[i][1]);
//                w -= coins[i][0];
//                coins[i][1] -= 1;
//                result[i] += 1;
//            }

            w -=

            for (int[] coin : coins) {
                System.out.print(Arrays.toString(coin) +" ");
            }
            System.out.println(Arrays.toString(result));
            System.out.println("w =" + w);
        }


        result[0] = w / 500;
        System.out.println(Arrays.toString(result));
    }
}