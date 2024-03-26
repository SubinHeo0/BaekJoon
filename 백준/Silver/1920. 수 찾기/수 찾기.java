import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(target, A, 0, A.length - 1));
        }

    }

    private static int binarySearch(int target, int[] arr, int start, int end) {
        if (start > end) return 0;
        int mid = start + ((end - start) / 2);
        if (target == arr[mid]) return 1;
        else if (target > arr[mid]) return binarySearch(target, arr, mid + 1, end);
        else return binarySearch(target, arr, start, mid - 1);
    }
}