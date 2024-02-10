import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 순회
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인오더 맨 왼쪽부터 차례대로 만나는 놈들 다 왼쪽부터 검색
        // 포스트 오더 맨 왼쪽부터 가장 아래(우선순위) 왼쪽에 있는 놈들부터 먼저 (왼쪽자식 -> 오른쪽자식 -> 뿌리) 모든 경우에서
        // 프리 오더 (뿌리 -> 왼쪽 자식 -> 오른쪽 자식)


    }
}