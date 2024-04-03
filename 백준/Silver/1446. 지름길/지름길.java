import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class ShortPath {
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

        // 지름길은 시작점을 기준으로 오름차순정렬, 시작점이 같으면 종료점을 기준으로 오름차순 정렬
        Collections.sort(path, Comparator.comparingInt((ShortPath p) -> p.start)
                .thenComparingInt(p -> p.end));

        int[] distance = new int[D + 1];
        int move = 0;
        int idx = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (move < D) {
            if (idx < path.size()) {
                ShortPath shortPath = path.get(idx);
                if (move == shortPath.start) { // 지름길의 시작점과 현재 위치가 같으면
                    distance[shortPath.end] = Math.min(distance[move] + shortPath.weight, distance[shortPath.end]);
                    idx++;
                } else { // 지름길을 만날때까지 distance를 채우면서 move+1
                    distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                    move++;
                }
            } else { // 저장된 지름길을 다 탐색하고 남은 distance[]는 그냥 최소 move+1로 채우기
                distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                move++;
            }
        }

        System.out.println(distance[D]);

    }
}