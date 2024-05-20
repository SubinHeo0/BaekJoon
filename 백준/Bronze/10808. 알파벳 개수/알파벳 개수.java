import java.io.*;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            alphabet[c - 'a']++;
        }

        for (int cnt : alphabet) {
            bw.write(cnt + " ");
        }

        bw.flush();

    }
}