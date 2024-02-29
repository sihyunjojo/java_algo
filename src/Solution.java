import java.io.FileInputStream;
import java.io.*;
import java.util.*;


// 보호 필름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static class core {
        int x;
        int y;

        core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] arr;
    static int[][] copy;
    static int[] dx = { 0, -1, 0, 1, 0 };
    static int[] dy = { 0, 0, 1, 0, -1 };
    static List<core> list;
    static int[] result;
    static int[] dir = { 1, 2, 3, 4 };
    static int coreCount;
    static int answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Measure_time.runFunction( () -> {


//        System.setIn(new FileInputStream("InputFile/input1767.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            copy = new int[N][N];
            list = new ArrayList<>();
            coreCount = 0;
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 1) {
                        coreCount += 1;
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            list.add(new core(i, j));
                        }

                    }
                }
            }
            result = new int[list.size()];

            recursion(0, 0);
            System.out.println("#" + t + " " + answer);
        }
        });

    }

    private static void recursion(int idx, int start) {
        // TODO Auto-generated method stub
        if (idx == list.size()) {
            isOk();
            return;
        }
        for (int i = 0; i < 4; i++) {
            result[idx] = dir[i];
            recursion(idx + 1, i + 1);
        }
    }

    private static void isOk() {
        copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < list.size(); i++) {
            core now = list.get(i);
            int dir = result[i];
            nx = now.x;
            ny = now.y;
            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                copy[nx][ny] += 1;
                if (copy[nx][ny] >= 2) {
                    return;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == 1) {
                    count++;
                }
            }
        }
        int totalCount = count - coreCount;

        answer = Math.min(totalCount, answer);

    }

}
// 시간차이(ms) : 0.004948
