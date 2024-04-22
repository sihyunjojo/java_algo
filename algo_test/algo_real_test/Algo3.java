import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo3 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
				
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			int[][] rabbits = new int[5][2];
			loop:
			for (int i = 0; i < rabbits.length; i++) {
				 st = new StringTokenizer(br.readLine());
				rabbits[i][0] = Integer.parseInt(st.nextToken());
				rabbits[i][1] = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < 9; j++) {
					// 내리막길이면
					if (arr[j+1] < arr[j]) {
						if (rabbits[i][1] < arr[j] - arr[j+1]) {
							continue loop;
						}
					}
					// 오르막길이면
					if(arr[j+1] > arr[j]) {
						if(rabbits[i][0] < arr[j+1] - arr[j]) {
							continue loop;
						}
					}
				}
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
