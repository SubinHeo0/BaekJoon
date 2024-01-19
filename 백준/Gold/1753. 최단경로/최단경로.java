import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        private int v;
        private int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static List<List<Node>> graph;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        // 그래프 입력값으로 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    private static void dijkstra(int start) {
        // 우선 순위 큐 사용, 가중치를 기준으로 오름차순 정렬
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        // 시작 노드 초기화
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            // 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            Node now = queue.poll();
            if (!visited[now.v]) visited[now.v] = true;
            // 인접 노드들 중 방문하지 않은 노드에 대해서만 최단 거리 업데이트
            for (Node neighbor : graph.get(now.v)) {
                if (!visited[neighbor.v] && dist[neighbor.v] > now.w + neighbor.w) {
                    dist[neighbor.v] = now.w + neighbor.w;
                    queue.add(new Node(neighbor.v, dist[neighbor.v]));
                }
            }
        }
    }
}