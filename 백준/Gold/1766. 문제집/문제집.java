import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inputCnt = new int[N + 1]; // 전입차수 저장
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            graph.get(first).add(last);
            inputCnt[last] += 1;
        }

        // 위상정렬 우선순위큐
        // 전입차수가 0인 문제 큐에 추가
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inputCnt[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer first = q.poll();
            sb.append(first).append(" ");
            if (!graph.get(first).isEmpty()) {
                for (Integer last : graph.get(first)) { // first에 인접한 값의 진입차수 감소
                    inputCnt[last]--;
                    if (inputCnt[last] == 0) q.offer(last);
                }
            }
        }

        System.out.println(sb);

    }
}
