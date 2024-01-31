//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Solution {
//    public static void main(String args[]) throws Exception {
////        System.setIn(new FileInputStream("./input2.txt"));
////
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////
//////        0’으로 채워진 평면상에 사다리는 연속된 ‘1’로 표현된다. 도착 지점은 '2'로 표현된다).
////
////        int t = Integer.parseInt(br.readLine());
////        System.out.println(t);
////        for (int tc = 1; tc <= t; tc++){
////            int result = 0;
////            int[][] board = new int[100][100];
////            List<Integer> start_points = new ArrayList<>();
////
////            for (int i = 0; i < 100; i++){
////                StringTokenizer st = new StringTokenizer(br.readLine());
////                for (int j = 0; j < 100; j++){
////                    board[i][j] = Integer.parseInt(st.nextToken());
////                    if (i==0 && board[i][j] == 1) start_points.add(j);
////                }
////            }
////
////            for (int x: start_points){
////                int y = 1;
////                while (y <= 99){
////                    if (isBound(y,x+1) && board[y][x+1] == 1){
////                        while (isBound(y,x+1) && board[y][x+1] == 1){
////                            x += 1;
////                            System.out.println("x"+x);
////                        }
////                        continue;
////                    }
////                    if (isBound(y,x-1) && board[y][x-1] == 1){
////                        while (isBound(y,x-1) && board[y][x-1] == 1){
////                            x -= 1;
////                            System.out.println("-x"+x);
////                        }
////                        continue;
////                    }
////
////                    if (isBound(y+1,x) && board[y+1][x] == 1){
////                        count += 1;
////                        y += 1;
////                        System.out.println(y);
////                    }
////                }
////                System.out.println(count);
////                result = Math.min(result,count);
////                System.out.println(result+"----------------------");
////            }
////
////            System.out.printf("#%d %d\n",tc, result);
////        }
////    }
////    public static boolean isBound(int y, int x) {
////        return y >= 0 && x >= 0 && y < 100 && x < 100;
//    //}
//}
