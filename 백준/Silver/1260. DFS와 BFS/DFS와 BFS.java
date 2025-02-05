import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] dfsVisited;
    private static boolean[] bfsVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작할 정점 번호

        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for (List<Integer> nodes : graph) {
            Collections.sort(nodes);
        }

        dfsVisited[V] = true;
        DFS(V);

        System.out.println();

        BFS(V);

    }

    private static void DFS(int start) {
        System.out.print(start + " ");
        for (Integer next : graph.get(start)) {
            if (!dfsVisited[next]) {
                dfsVisited[next] = true;
                DFS(next);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        bfsVisited[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            System.out.print(now + " ");
            for (Integer next : graph.get(now)) {
                if (!bfsVisited[next]) {
                    bfsVisited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

}