import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] nums;
    private static int[] op = new int[4]; // + - * /
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
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int idx, int sum) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) { // 연산자를 돌면서 순열 만들기
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        dfs(idx + 1, sum + nums[idx]);
                        break;
                    case 1:
                        dfs(idx + 1, sum - nums[idx]);
                        break;
                    case 2:
                        dfs(idx + 1, sum * nums[idx]);
                        break;
                    default:
                        dfs(idx + 1, sum / nums[idx]);
                }
                op[i]++;
            }
        }
    }

}