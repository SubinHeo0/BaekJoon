import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] check; // 각 노드가 속해있는 집합을 0과 1로 분류할 것
    static boolean isEven; // 이분 그래프인지 확인

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]); // 정점의 개수
            int E = Integer.parseInt(input[1]); // 간선의 개수
            // 초기화
            visited = new boolean[V + 1];
            graph = new ArrayList[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            // 그래프 입력값으로 초기화
            for (int j = 0; j < E; j++) { // 1
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                graph[u].add(v);
                graph[v].add(u);
            }
            // 모든 정점들에 대해서 DFS 수행
            for (int j = 1; j <= V; j++) {
                if (isEven) DFS(j);
                else break;
            }

            if (isEven) System.out.println("YES");
            else System.out.println("NO");

        }

    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                // 바로 직전에 있는 노드가 속해있는 집합과 다른 집합으로 분류
                check[neighbor] = (check[node] + 1) % 2; // 직전 노드 집합이 0이면 1로, 1이면 0으로
                DFS(neighbor);
            } else if (check[neighbor] == check[node]) isEven = false;
        }
    }

}