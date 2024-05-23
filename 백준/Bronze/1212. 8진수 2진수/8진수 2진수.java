import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine(); // 8진수

        if (N.equals("0")) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';
            sb.append(change(n));
        }

        // sb의 젤 첫 문자가 0이면 삭제
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        System.out.println(sb);

    }

    // 8진수 -> 2진수
    private static StringBuilder change(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        while (sb.length() < 3) {
            sb.append(0);
        }
        return sb.reverse();
    }
}