import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;

        Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 양수면 자리바꿈
        }
    }

    private static int N;
    private static int[][] cave;
    private static int[][] distance;
    private static int[] dx = {1, 0, -1, 0}; // 행
    private static int[] dy = {0, 1, 0, -1}; // 열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[0][0] = cave[0][0];

            sb.append("Problem ").append(cnt++).append(": ").append(dijkstra()).append("\n");

        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, cave[0][0]));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.row + dx[i]; // 행
                int nextY = now.col + dy[i]; // 열

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) { //인접 값이 유효하면 distance 엽데이트 후 업데이트에 영향을 준 노드 큐에 추가
                    if(distance[nextX][nextY] > distance[now.row][now.col] + cave[nextX][nextY]){
                        distance[nextX][nextY] = distance[now.row][now.col] + cave[nextX][nextY];
                        q.add(new Node(nextX, nextY, distance[nextX][nextY]));
                    }
                }
            }
        }
        return distance[N - 1][N - 1];
    }
}
