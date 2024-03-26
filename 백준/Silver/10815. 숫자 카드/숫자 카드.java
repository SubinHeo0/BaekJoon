import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(target, cards, 0, N - 1) + " ");
        }

    }

    private static int binarySearch(int target, int[] cards, int start, int end) {
        if (start > end) return 0;

        int mid = start + ((end - start) / 2);

        if (target == cards[mid]) return 1;
        else if (target > cards[mid]) return binarySearch(target, cards, mid + 1, end);
        else return binarySearch(target, cards, start, mid - 1);
    }
}