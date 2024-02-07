import java.io.*;
import java.util.*;

// 메모리 4mb
// 함수 만들어서 소수이면 for문 돌려주고 맞으면 sb에 넣어주고
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] isso;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       int MAX_N = 8;
       boolean[] isso = new boolean[(int) Math.pow(10,n+1)];


        System.out.println(sb);
    }
    private void fun(){

    }

    private boolean check(int num){
        for (int i = n; i > 0; i--){
            if (isso[(int) (num % (Math.pow(10,i)))]) {

            }
        }
    }
}