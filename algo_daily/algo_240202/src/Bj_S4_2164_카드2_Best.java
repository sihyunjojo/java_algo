import java.util.Scanner;

public class Bj_S4_2164_카드2_Best {
    public static void main(String[] args) {
        //		나보다 하나 작은 제곱수를 찾아서
        //		거기부터 거리 *2를 더한건데
        //		그게 나 이면 거리가 0 이니까
        //		이러면 10억 까지의 값도 시간초과 안남
        //		4는 4가 나오고
        //		8은 8이 나오고
        //		16은 16이 나오는데용
        //
        //		쟤네들은 반씩 줄어도 계속 짝수기 떄매 맨뒤에값이 남는거고
        //		홀수갯수가 되는 경우가 생기면 뒤틀리는데
        //		5는 2
        //		6은 4
        //		7은 6
        //		8은 8
        //		9는 2
        //		10은 4
        //		11은 6
        //		12는 8
        //		13은 10
        //		14는 12
        //		15는 14
        //		16은 16
        //		이렇게 한칸씩 밀리거든요
        //		그래서 가장 가까운 제곱수를 찾아서 그놈과의 거리 * 2 를 뺴거나 더하면 되용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = 1;
        while( n < N ) {
            n *= 2;
        }
        n /= 2;
        if( N == 1 )
            System.out.println(1);
        else
            System.out.println( (N-n) * 2 );
    }
}
