import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 키 비교 횟수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; // 진입 차수 배열
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            indegree[end]++;
        }
        // 위상 정렬 실행
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int neighbor : graph.get(now)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.add(neighbor);
            }
        }

    }
}