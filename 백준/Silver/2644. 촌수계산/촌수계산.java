import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int N;
    private static int[] parent; // 부모 번호 저장
    private static List<List<Integer>> children = new ArrayList<>(); // 자식 번호 저장
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            children.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 부모
            int c = Integer.parseInt(st.nextToken()); // 자식
            parent[c] = p;
            children.get(p).add(c);
        }

        int answer = bfs(start, end);
        System.out.println(answer != 0 ? answer : -1);

    }

    private static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;

        int level = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == end) {
                    flag = true;
                    return level;
                }
                // now의 부모와 now의 children 큐에 삽입(방문하지 않았으면)
                if (parent[now] != 0 && !isVisited[parent[now]]) {
                    isVisited[parent[now]] = true;
                    q.offer(parent[now]);
                }
                for (int child : children.get(now)) {
                    if (!isVisited[child]) {
                        isVisited[child] = true;
                        q.offer(child);
                    }
                }
            }
            level++;
        }

        if (!flag) return 0;
        return level;
    }

}