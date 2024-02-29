import java.io.BufferedReader;
import java.io.FileInputStream;
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

        @Override
        public String toString() {
            return "core [x=" + x + ", y=" + y + "]";
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
    static int totalMinCount;
    static int totalMaxLine;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("InputFile/input1767.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            copy = new int[N][N];
            list = new ArrayList<>();
            totalMinCount = Integer.MAX_VALUE;
            totalMaxLine = Integer.MIN_VALUE;
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
            System.out.println(list.size());
            dps(0, 0, 0);
            System.out.println("#" + t + " " + totalMinCount);
        }

    }

    private static void dps(int idx, int maxLine, int lineCount) {
        // TODO Auto-generated method stub
        if (idx == list.size()) {

            if(totalMaxLine < maxLine ) {
                totalMaxLine = maxLine;
                totalMinCount = lineCount;
            }
            else if( totalMaxLine == maxLine) {
                if(lineCount < totalMinCount) {
                    totalMinCount = lineCount;
                }
            }
            return;
        }


        dps(idx+1, maxLine, lineCount);
        core now = list.get(idx);

        for(int i=1; i<5; i++) {
            int nx = now.x;
            int ny = now.y;

            int count =0;
            while(true) {
                nx += dx[i];
                ny += dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N) {
                    break;
                }

                if(arr[nx][ny]==1) {
                    count =0;
                    break;
                }
                count++;
            }

            if(count!=0 ) {
                nx = now.x;
                ny = now.y;

                for(int k=0; k<count; k++) {
                    nx += dx[i];
                    ny += dy[i];
                    arr[nx][ny] =1;
                }

                dps(idx+1, maxLine+1, lineCount+count);

                nx = now.x;
                ny = now.y;

                for(int k=0; k<count; k++) {
                    nx += dx[i];
                    ny += dy[i];
                    arr[nx][ny] =0;
                }
            }

        }

    }

}