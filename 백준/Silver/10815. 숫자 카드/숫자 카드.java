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
            int start = 0;
            int end = N - 1;
            int answer = 0;
            while (start <= end) {
                int mid = start + ((end - start) / 2);
                if (find == cards[mid]) {
                    answer = 1;
                    break;
                } else if (find > cards[mid]) start = mid + 1;
                else end = mid - 1;
            }
            bw.write(answer + " ");
        }

        bw.flush();

    }

}