import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 입구 도착 후 1분 뒤에 내려갈 수 있음
// 계단 위에 동시 최대 3명까지만 가능
// 이미 계단 3명 내려가고 있는 경우, 1명이 완전히 내려갈 때까지 계단입구에서 대기
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int n, res;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("InputFile/input2105.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= tc; t++) {
//
//        }
        System.out.println(sb);
    }
}
