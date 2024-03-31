import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long sum = 0L;
        long num = 1L;

        while (true) {
            sum += num;
            if (sum > N) break;
            num++;
        }

        System.out.println(num - 1);

    }
}