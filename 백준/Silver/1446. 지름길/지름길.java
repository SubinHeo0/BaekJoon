import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class ShortPath {
        int start;
        int end;
        int weight;

        ShortPath(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<ShortPath> path = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 조건에 맞는 길만 지름길로 인정
            if (e > D) continue;
            if (e - s > w) path.add(new ShortPath(s, e, w));
        }

        // 지름길 정렬(시작점 기준 정렬, 시작점이 같으면 종료점 기준 정렬)
        Collections.sort(path, Comparator.comparingInt((ShortPath p) -> p.start)
                .thenComparingInt(p -> p.end));

        int[] distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        int move = 0; // 현재 이동거리
        int idx = 0; // 지름길 하나하나 탐색

        while (move < D) {
            while (idx < path.size()) { // 지름길 탐색
                ShortPath p = path.get(idx);
                if (move == p.start) { // 현재위치가 지름길 시작과 같을 때
                    if (distance[p.end] > distance[move] + p.weight) {
                        distance[p.end] = distance[move] + p.weight;
                    }
                    idx++;
                } else { //지름길의 시작점을 만날 때까지 move++
                    if (distance[move + 1] > distance[move] + 1) {
                        distance[move + 1] = distance[move] + 1;
                    }
                    move++;
                }
            }
            // 지름길 탐색 끝
            if (distance[move + 1] > distance[move] + 1) {
                distance[move + 1] = distance[move] + 1;
            }
            move++;
        }

        System.out.println(distance[D]);

    }
}