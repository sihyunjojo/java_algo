import java.io.*;
import java.util.Arrays;

//수열과 쿼리 17 실패
public class Main {
<<<<<<< Updated upstream
    static int res, n;
    static int[] arr, tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[getTreeSize(n)];
        treeInit(0, n - 1, 1);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (select == 1) {
                arr[first] = second;
            }
            if (select == 2) {
                int min = Integer.MAX_VALUE;
                for (int j = first; j <= second; j++) {
                    if (min > arr[j]) min = arr[j];
                }
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int treeInit(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(treeInit(start,mid,node*2), update(mid+1, end, node*2+1));
    }

    private static int update(int start, int end, int node) {

        return start;
    }

    private static int getTreeSize(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, h) - 1;
    }

=======
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Planet {
        int radius;
        Point point;

        public Planet(int x, int y, int radius) {
            this.radius = radius;
            this.point = new Point(x, y);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tc; i++) {
            int[] arr = getIntArrFromStr(br.readLine());
            Point startPoint = new Point(arr[0], arr[1]);
            Point endPoint = new Point(arr[2], arr[3]);
            int num = Integer.parseInt(br.readLine());
            int res = 0;
                
            for (int j = 0; j < num; j++) {
                int[] planetArr = getIntArrFromStr(br.readLine());
                Planet planet = new Planet(planetArr[0], planetArr[1], planetArr[2]);
                if (isPointInPlanet(startPoint, planet) ^ isPointInPlanet(endPoint, planet)) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    

    static int[] getIntArrFromStr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static boolean isPointInPlanet(Point point, Planet planet) {
        Point planetPoint = planet.point;
        double distance = Math.sqrt(Math.pow(planetPoint.x - point.x, 2) + Math.pow(planetPoint.y - point.y, 2));
        return distance <= planet.radius;
    }
>>>>>>> Stashed changes
}