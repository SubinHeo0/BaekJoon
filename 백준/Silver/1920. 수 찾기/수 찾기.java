import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
            int find = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(find, cards, 0, N - 1) + "\n");
        }

        bw.flush();

    }

    private static int binarySearch(int find, int[] cards, int start, int end) {
        if (start > end) return 0;
        int mid = start + ((end - start) / 2);
        if (find == cards[mid]) return 1;
        else if (find > cards[mid]) return binarySearch(find, cards, mid + 1, end);
        else return binarySearch(find, cards, start, mid - 1);
    }
}