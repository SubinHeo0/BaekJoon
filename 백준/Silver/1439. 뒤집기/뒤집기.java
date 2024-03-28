import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int zero = 0;
        int one = 0;

        if (S.charAt(0) == '0') zero++;
        else one++;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) == '0') zero++;
                else one++;
            }
        }

        System.out.println(Math.min(zero, one));

    }
}