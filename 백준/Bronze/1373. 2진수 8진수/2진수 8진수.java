import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine(); // 2진수 11/001/100 len:8

        // 2진수를 8진수로 바꾸려면 3자리씩 끊어야 함
        // 뒤에서부터 끊었을때 3자리가 안되면 앞부분에 0추가해서 3자리로 맞추기
        while (N.length() % 3 != 0) {
            N = "0" + N;
        }

        // 011/001/100
        for (int i = 0; i < N.length(); i += 3) {
            sb.append((N.charAt(i) - '0') * 4 +
                    (N.charAt(i + 1) - '0') * 2 +
                    (N.charAt(i + 2) - '0'));
        }

        System.out.println(sb);

    }
}