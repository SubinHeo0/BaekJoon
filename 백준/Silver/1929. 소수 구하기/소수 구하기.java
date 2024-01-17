import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] nums = new int[N + 1];
        // 배열 인덱스값으로 초기화
        for (int i = 2; i <= N; i++) { // 1은 소수가 아니므로 0으로 초기화, 2부터 인덱스값으로 초기화
            nums[i] = i;
        }
        // 소수 찾기(에라토스테네스의 체)
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (nums[i] == 0) continue; // 0이면 볼 필요 없음
            for (int j = i + i; j <= N; j += i) { // 배열을 돌면서 i의 배수는 0으로 바꾸기(i 자기자신은 제외)
                nums[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (nums[i] != 0) System.out.println(nums[i]);
        }

    }
}