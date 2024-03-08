import java.util.*;
import java.io.*;

public class Swea_2105_디저트카페_NotMy {

    static int answer;
    static int size;
    static int[][] map;
    //우하 -> 좌하 -> 상좌 -> 상우
    static int[] dx = {1, -1, -1, 1};
    static int[] dy = {1, 1, -1, -1};
    //먹은것을 기억하는 배열
    static boolean[] visited;
    //출발점
    static int startX, startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int c = 1; c <= tc; c++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            answer = -1;
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < size - 2; i++) {
                for (int j = 1; j < size - 1; j++) {
                    //dfs
                    startX = j;
                    startY = i;
                    visited = new boolean[101];
                    visited[map[i][j]] = true;
                    dfs(j, i, j, i, 1, 0);
                }
            }

            System.out.println("#" + c + " " + answer);
        }
    }

    static void dfs(int x, int y, int preX, int preY, int cnt, int start) {
        for (int i = start; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            //인덱스 오류
            if (mx < 0 || my < 0 || mx >= size || my >= size) continue;
            //재귀가 실행되고 만약 지난 경로가 같다면 패스
            if (preX == mx && preY == my) continue;

            //출발점과 동일하다면
            if (startX == mx && startY == my) {
                //검사
                answer = Math.max(cnt, answer);
                return;
            }
            //방문여부를 여기서 처리한건 위의 코드때문
            if (visited[map[my][mx]]) continue;

            //방문 처리
            visited[map[my][mx]] = true;
            dfs(mx, my, x, y, cnt + 1, i);
            visited[map[my][mx]] = false;
        }
    }
}
