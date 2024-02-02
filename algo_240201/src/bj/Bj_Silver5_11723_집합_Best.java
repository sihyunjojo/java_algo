package bj;

import java.util.Scanner;
public class Bj_Silver5_11723_집합_Best {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int S = 0;
        for(int i = 0; i<n; i++) {
            String com = sc.next();
            if(com.equals("add")) {
                int num = sc.nextInt();
                S=S|(1<<num);
            }
            else if(com.equals("remove")) {
                int num = sc.nextInt();
                S=S&~(1<<num);
            }
            else if(com.equals("check")) {
                int num = sc.nextInt();
                if((S&(1<<num))>0) sb.append("1 \n");
                else sb.append("0 \n");
            }
            else if(com.equals("toggle")) {
                int num = sc.nextInt();
                S=S^(1<<num);
            }
            else if(com.equals("all")) {
                S=(1<<21)-1;
            }
            else
                S=0;
        }
        System.out.println(sb);
    }
}