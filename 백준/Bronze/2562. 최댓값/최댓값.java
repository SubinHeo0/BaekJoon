import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = (max >= arr[i]) ? max : arr[i];
        }

        bw.write(max + "\n");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                bw.write(Integer.toString(i + 1));
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
