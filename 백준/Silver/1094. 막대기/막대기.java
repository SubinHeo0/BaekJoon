import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int start = 64;
        int count = 0;
        while (X > 0) {
            if (start > X) start /= 2;
            else {
                X -= start;
                count++;
            }
        }

        System.out.println(count);

    }
}