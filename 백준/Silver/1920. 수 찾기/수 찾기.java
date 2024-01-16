import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int startIdx = 0;
            int endIdx = A.length - 1;
            while (startIdx <= endIdx) {
                int midIdx = (startIdx + endIdx) / 2;
                int mid = A[midIdx];
                if (target < mid) endIdx = midIdx - 1;
                else if (target > mid) startIdx = midIdx + 1;
                else {
                    find = true;
                    break;
                }
            }
            if (find) System.out.println(1);
            else System.out.println(0);
        }

    }
}