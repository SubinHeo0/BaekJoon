import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static boolean[] visited;
    private static int[] dist;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        dist = new int[V + 1]; // 가중치 배열
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE; // 무한대로 초기화
            graph.add(new ArrayList<>());
        }

        // 그래프 입력값으로 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.v] = true;
            for (Node neighbor : graph.get(now.v)) {
                if (!visited[neighbor.v] && dist[neighbor.v] > now.w + neighbor.w) {
                    dist[neighbor.v] = now.w + neighbor.w;
                    queue.add(new Node(neighbor.v, dist[neighbor.v]));
                }
            }
        }
    }
}