import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 인덱스:열, 값:행

        nQueen(0);
        System.out.println(count);

    }

    private static void nQueen(int depth) { //depth:열
        if (depth == N) {
            count++;
            return;
        }

        // 첫 번째 행부터 가능한지 검사
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) nQueen(depth + 1);
        }

    }

    private static boolean isPossible(int col) { // 해당 열에 놓을 수 있는지 검사
        for (int i = 0; i < col; i++) { // 이전 열(인덱스) 탐색 | 이전 인덱스에 같은 값이 있으면 안됨(같은 행), 대각선에 있으면 안됨
            if (arr[i] == arr[col]) return false;
            else if (col - i == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}