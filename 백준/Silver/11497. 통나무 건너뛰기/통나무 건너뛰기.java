import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] log = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                log[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(level(log));
        }

    }

    private static int level(int[] log) {
        Arrays.sort(log);

        Queue<Integer> even = new LinkedList<>(); // 짝수 인덱스 값 모음
        Stack<Integer> odd = new Stack<>(); // 홀수 인덱스 값 모음 | 나중에 뒤집어서 even 뒤에 이어붙여야하므로 stack으로 구현

        for (int i = 0; i < log.length; i++) {
            if (i % 2 == 0) even.add(log[i]);
            else odd.add(log[i]);
        }

        for (int i = 0; i < log.length; i++) { // even 순서대로 출력후 odd 이어붙이기
            if(!even.isEmpty()) log[i] = even.poll();
            else log[i] = odd.pop();
        }

        // 최대 높이차 구하기
        int max = Math.abs(log[0] - log[log.length - 1]);
        for (int i = 0; i < log.length - 1; i++) {
            int j = i + 1;
            if (Math.abs(log[i] - log[j]) > max) max = Math.abs(log[i] - log[j]);
        }

        return max;

    }
}