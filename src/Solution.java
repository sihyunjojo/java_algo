import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static int N;
    static int answer, minN, maxN;
    static int[] operator, numbers, makeSik;
    static int cnt;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("inputFile/input4008.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            minN = 100000000;
            maxN = -100000000;

            N = sc.nextInt();
            operator = new int[4];
            numbers = new int[N];
            makeSik = new int[N-1];

            for(int i=0; i<4; i++) {
                operator[i] = sc.nextInt();
            }

            for(int i=0; i<N; i++) {
                numbers[i] = sc.nextInt();
            }

            checkAll(0);

            answer = maxN-minN;
            System.out.println(cnt);
            System.out.println("#"+tc+" "+answer);
        }

    }
    static void checkAll(int idx) {

        // 연산자 추가 완료!
        if(idx == N-1) {
            calcNum();
        }

        for(int i=0; i<4; i++) {
            // 해당 연산자 이미 다 사용함
            if(operator[i] == 0)
                continue;

            operator[i]--;
            makeSik[idx] = i;
            checkAll(idx+1);
            operator[i]++;
        }

    }

    static void calcNum() {
        int num = numbers[0];
        for(int i=0; i<N-1; i++) {
            cnt += 1;
            // +

            if(makeSik[i] == 0) {
                num+=numbers[i+1];
            }
            // -
            else if(makeSik[i] == 1) {
                num-=numbers[i+1];
            }
            // *
            else if(makeSik[i] == 2) {
                num*=numbers[i+1];
            }
            // /
            else if(makeSik[i] == 3) {
                num/=numbers[i+1];
            }
        }
        if(num > maxN)
            maxN = num;
        if (num < minN)
            minN = num;

    }

}