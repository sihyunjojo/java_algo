import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] board;
	static int[][] start,end;
	static int[][] delta1 = new int[][] {{-1,-1},{0,-1},{1,-1},{1,1},{0,1},{-1,1}};
	static int[][] delta0 = new int[][] {{-1,-1},{-1,0},{-1,1},{1,1},{1,0},{1,-1}};
	static int[][] delta = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		n = Integer.parseInt(br.readLine());
		
		board = new char[n][n];
		start = new int[3][2];
		end = new int[3][2];
		
		int startNum = 0;
		int endNum = 0;
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray(); 
			for (int j = 0; j < n; j++) {	
				if (board[i][j] == 'B') {
					start[startNum][0] = i;
					start[startNum++][1] = j;
				}
				if (board[i][j] =='E' ) {
					end[endNum][0] = i;
					end[endNum++][1] = j;
				}
			}
		}
		
		int tmp = 0;
		// Y가 같으니 세로라는 뜻.
		if (start[0][0] == start[1][0]) {
			tmp = 1;
		}
		
		int endDir = 0;
		// Y가 같으니 세로라는 뜻.
		if (end[0][0] == end[1][0]) {
			endDir = 1;
		}
			
		// 중심과 가로인지 세로인지 넣음 (0,1)
		ArrayDeque<Integer[]> qArrayDeque = new ArrayDeque<>();
		qArrayDeque.offer(new Integer[] {start[1][0],start[1][1],tmp,1});
		boolean[][][] isvisited = new boolean[n][n][2];
		isvisited[start[1][0]][start[1][1]][tmp]= true; 
		
		while (!qArrayDeque.isEmpty()) {
			Integer[] poll = qArrayDeque.poll();
			int y = poll[0];
			int x = poll[1];
			int direct = poll[2];
			int dis = poll[3];
			
			if (y == end[1][0] && x == end[1][1] && endDir == direct) {
				System.out.println(dis);
				break;
			}
			// 상하좌우 움직
			// 세로면
			if (direct == 1) {
				// 위아래 움직
				for (int i = 0; i < 2; i++) {
					int dy = y + delta[i][0] + delta[i][0];
					int dx = x + delta[i][1] + delta[i][1];
					if (!checkSize(dy, dx)) continue;
					if (board[dy][dx] == '1') continue;
					if (isvisited[y+delta[i][0]][x][direct]) continue;
					isvisited[y+delta[i][0]][x][direct] = true;
					qArrayDeque.offer(new Integer[] {y+delta[i][0],x,direct,dis+1});
				}
				// 좌우로 크게 움직
				loop:
				for (int i = 2; i < 4; i++) {
					if (isvisited[y][x+delta[i][1]][direct]) continue loop;
					for (int j = -1; j < 1; j++) {
						int dy = y + j;
						int dx = x + delta[i][1];
						if (!checkSize(dy, dx)) continue loop;
						if (board[dy][dx] == '1') continue loop;
						}
					isvisited[y][x+delta[i][1]][direct] = true;
					qArrayDeque.offer(new Integer[] {y,x+delta[i][1],direct,dis+1});
				}
			}
			else {
				// 좌우로 움직
				for (int i = 2; i < 4; i++) {
					int dy = y + delta[i][0] + delta[i][0];
					int dx = x + delta[i][1] + delta[i][1];
					if (!checkSize(dy, dx)) continue;
					if (board[dy][dx] == '1') continue;
					if (isvisited[y][x+delta[i][1]][direct]) continue;
					isvisited[y][x+delta[i][1]][direct] = true;
					qArrayDeque.offer(new Integer[] {y,x+delta[i][1],direct,dis+1});
				}
				// 위아래로 크게 움직
				loop:
				for (int i = 0; i < 2; i++) {
					if (isvisited[y+delta[i][0]][x][direct]) continue loop;
					for (int j = -1; j < 1; j++) {
						int dy = y + delta[i][0];
						int dx = x + j;
						if (!checkSize(dy, dx)) continue loop;
						if (board[dy][dx] == '1') continue loop;
						}
					isvisited[y+delta[i][0]][x][direct] = true;
					qArrayDeque.offer(new Integer[] {y+delta[i][0],x,direct,dis+1});
				}
			}
			
			// 돌리기
			if (checkDoligi(y, x,direct)) {
				isvisited[y][x][(direct+1)%2] = true;
				qArrayDeque.offer(new Integer[] {y,x,((direct+1)%2),dis+1});
			}
		}
	}
	
	static boolean checkDoligi(int y, int x, int direct) {
		if (direct == 0) {
			for (int i = 0; i < 6; i++) {
				int dy = y + delta0[i][0];
				int dx = x + delta0[i][1];
				if (!checkSize(dy, dx)) {
					return false;
				}
				if (board[dy][dx] == '1') {
					return false;
				}
			}
		}
		else {
			for (int i = 0; i < 6; i++) {
				int dy = y + delta1[i][0];
				int dx = x + delta1[i][1];
				if (!checkSize(dy, dx)) {
					return false;
				}
				if (board[dy][dx] == '1') {
					return false;
				}
			}
		}

		
		return true;
	}
	
	static boolean checkSize(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}
