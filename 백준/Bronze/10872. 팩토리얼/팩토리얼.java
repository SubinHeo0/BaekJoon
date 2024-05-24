import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 1L;

        if (N == 0) {
            System.out.println(1);
            return;
        }

        for (int i = N; i > 0; i--) {
            sum *= i;
        }

        System.out.println(sum);

    }
}