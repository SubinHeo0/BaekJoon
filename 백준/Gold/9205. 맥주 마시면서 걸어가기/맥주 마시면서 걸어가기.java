import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private final static int MAX_DISTANCE = 50;
    private final static int MAX_BEER = 20;
    private static Point start;
    private static List<Point> stores;
    private static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            flag = false; // happy / sad 판단 플래그

            int storeCnt = Integer.parseInt(br.readLine());
            stores = new ArrayList<>(); // stores의 마지막 인덱스에는 도착 좌표 저장

            // 출발 좌표
            start = input(new StringTokenizer(br.readLine()));

            // 편의점 좌표
            for (int j = 0; j < storeCnt; j++) {
                Point store = input(new StringTokenizer(br.readLine()));
                stores.add(store);
            }

            // 도착 좌표
            Point end = input(new StringTokenizer(br.readLine()));
            stores.add(end);

            bfs();

            if (flag) sb.append("happy");
            else sb.append("sad");
            sb.append("\n");

        }

        System.out.println(sb);

    }

    private static Point input(StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        return new Point(x, y);
    }

    private static boolean isWithin(Point start, Point end) {
        return (Math.abs(start.x - end.x) + Math.abs(start.y - end.y)) <= MAX_DISTANCE * MAX_BEER;
    }

    private static void bfs() {
        boolean[] isVisited = new boolean[stores.size()];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < stores.size(); i++) {
                Point next = stores.get(i);
                if (!isVisited[i] && isWithin(now, next)) {
                    if (i == stores.size() - 1) {
                        flag = true;
                        return;
                    }
                    isVisited[i] = true;
                    q.offer(next);
                }
            }
        }
    }

}