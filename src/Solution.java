import java.io.*;
import java.util.*;

// 두 합이 하나의 값에 가까까운 값이 될때까지 찾는 문제
// 투 포인터?? 이진 탐색??
// 이진트리는 아닌 거 같은데 내가 부족해서 안 보이는 걸 수 도 있겠다.
public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("inputFile/input9229.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());


        for (int t = 1; t <= tc; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 200 000
            int result = -1;

            TreeSet<Integer> s = new TreeSet<>(List.of(m));

            System.out.println(t);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                int weight = Integer.parseInt(st.nextToken());
                if (weight < m) {
                    s.add(weight);
                    if (s.size() > 1) continue;
                    if (weight < m/2) result = weight + s.tailSet(weight).last();
                    else result = weight + s.headSet(weight).first();
                    if (s.contains(m-weight)) {
                        result = m;
                        break;
                    }
                }
            }
//            System.out.println(s.ceiling(1)); // 인자보다 크거나 같은 정수값을 double형으로 반환.
//            System.out.println(s.floor(1)); // 인자보다 작거나 같은 정수값을 double형으로 반환.
//            System.out.println(s.headSet(21)); // 가장 작은 값부터 인자로 넘긴값 직전(미만)까지의 요소들을 셋으로 리턴합니다
//            s.tailSet(20); // tailSet() : 가장 큰 값부터 인자로 넘긴값까지 포함해서 요소들을 셋으로 리턴합니다.
//            subSet() : 인자로 넘긴 A와 B사이의 인자들을 셋으로 리턴합니다. A인자는 포함되고 B인자 직전까지의 요소들만 리턴됩니다.
//            s.subSet(fromElement, toEelement);
//            System.out.println(s.pollFirst()); // 가장 작은 값이 가장 처음에 들어가 있네.
            System.out.println(s);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
