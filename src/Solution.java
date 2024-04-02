import java.util.*;

public class Solution {
    static HashMap<Long, Long> f;
    static long start, end, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        f = new HashMap<Long, Long>();

        long sum = 0;
        for(long i=0; i<10; i++) {
            sum += i;
            f.put(i, sum);
        }

        for(int t=1; t<=tc; t++) {
            start = sc.nextLong();
            end = sc.nextLong();

            if(start > 0)
                ans = F(end) - F(start-1);
            else
                ans = F(end) - F(start);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static long F(long i) {
        if(f.containsKey(i)) return f.get(i);

        if(i<10) return f.get(i);

        long v = V(i); // 자리 단위 100, 1000
        long F = F(i-1-i%v); // 가장 가까운 9 , 99, 999
        long G = (i/v)*(i%v+1)+ F(i%v); // 100 ~ i
        long num = F+G; // 최종 값을 더해서 알려줌.

        f.put(i, num);

        return num;
    }

    static long V(long i) {
        long v = 1;
        while(i>=10) {
            v = v*10;
            i = i/10;
        }
        return v;
    }
}



