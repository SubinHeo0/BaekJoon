import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'a';
            if (alphabet[idx] == -1) alphabet[idx] = i;
        }

        for (int cnt : alphabet) {
            bw.write(cnt + " ");
        }

        bw.flush();

    }
}