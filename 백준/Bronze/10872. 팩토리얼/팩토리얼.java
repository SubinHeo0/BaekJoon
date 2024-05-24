import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fact(N));

    }

    private static int fact(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return n * fact(n - 1);
    }
}