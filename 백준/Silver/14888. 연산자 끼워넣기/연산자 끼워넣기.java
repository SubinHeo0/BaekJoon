import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int[] nums;
    private static int[] operator = new int[4]; // + - * / 개수 저장
    private static List<Integer> detailOp = new ArrayList<>(); // 사용되는 연산자 번호를 모두 저장 [0,2,2,2, ...]
    private static boolean[] isVisited;
    private static int[] sequence;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
            if (operator[i] != 0) {
                for (int j = 0; j < operator[i]; j++) {
                    detailOp.add(i);
                }
            }
        }

        isVisited = new boolean[detailOp.size()];
        sequence = new int[detailOp.size()];

        dfs(0);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int idx) { // sequence 배열 채우기(연산자 순열 구하기)
        if (idx == detailOp.size()) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < sequence.length; i++) {
                q.offer(nums[i]);
                q.offer(sequence[i]);
            }
            q.offer(nums[N - 1]);

            calculate(q);
            return;
        }

        for (int i = 0; i < detailOp.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sequence[idx] = detailOp.get(i);
                dfs(idx + 1);
                isVisited[i] = false;
            }
        }
    }

    private static void calculate(Queue<Integer> q) {
        int sum = q.poll();
        while (!q.isEmpty()) {
            int op = q.poll();
            int num = q.poll();
            sum = cal(sum, op, num);
        }

        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }

    private static int cal(int sum, int op, int num) {
        switch (op) {
            case 0:
                return sum + num;
            case 1:
                return sum - num;
            case 2:
                return sum * num;
            case 3:
                int answer = Math.abs(sum) / num;
                return sum > 0 ? answer : -answer;

        }
        return 0;
    }

}