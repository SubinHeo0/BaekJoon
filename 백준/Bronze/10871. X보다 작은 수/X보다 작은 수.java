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

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());
        int[] a = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
            if (a[i] < x) {
                bw.write(a[i] + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
