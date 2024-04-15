import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[] visit;
    private static int[] parent;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        dfs(1); // 부모 저장

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();

    }

    private static void dfs(int idx) {
        visit[idx] = true;
        for (int neighbor : graph.get(idx)) {
            if (!visit[neighbor]) {
                parent[neighbor] = idx;
                dfs(neighbor);
            }
        }
    }
}
