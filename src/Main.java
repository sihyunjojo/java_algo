import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int res, n, m;
    static StringBuilder sb;
    static char[][] initboard;
    static int[] start;
    static int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        initboard = new char[9][9];

        for (int i = 0; i < 9; i++) {
            initboard[i] = br.readLine().toCharArray();
        }
        go();
    }

    static void go(){

    }
}