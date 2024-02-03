import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] A = new int[end + 1];
        // 배열 초기화
        for (int i = 2; i <= end; i++) { // 1은 소수가 아니므로 2부터 초기화
            A[i] = i;
        }
        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j <= end; j += i) {
                A[j] = 0;
            }
        }
        for (int i = start; i <= end; i++) {
            if (A[i] != 0) System.out.println(A[i]);
        }
    }


}