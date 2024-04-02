import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] arr; //인덱스:열, 값:행
    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);

    }

    private static void nQueen(int depth) { //depth가 열, i가 행
        // 열을 다돌면 경우의 수 1 증가
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) { // 0번째 행부터 경우의 수 count 시작
            arr[depth] = i;
            // 놓을 수 있는 위치면 재귀 호출
            if (isPosssible(depth)) nQueen(depth + 1); // 다음 열로 이동
        }
    }

    private static boolean isPosssible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false; // 같은 행에 존재할 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false; // 대각선에 존재할 경우
        }
        return true;
    }
}