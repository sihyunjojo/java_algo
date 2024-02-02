import java.io.*;
import java.util.*;

//  메모리 제한이 4메가 이므로 비트마스킹으로 풀어야할 가능성이 크다.
public class Bj_S4_2164_카드2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> cards = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            cards.addLast(i);
        }

        while(cards.size() > 1){
            cards.pollFirst();
            if (cards.size() == 1){
                break;
            }
            cards.addLast(cards.pollFirst());
        }
        System.out.println(cards.peek());
    }
}