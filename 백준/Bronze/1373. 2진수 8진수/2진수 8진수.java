import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine(); // 2진수

        // 2진수 -> 8진수
        // 3자리씩 끊은 2진수로 10진수값을 구해 그 값들을 이어붙이기

        // 3의 배수로 값 만들기(앞에 0붙이기)
        while (N.length() % 3 != 0) {
            N = "0" + N;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N.length(); i += 3) {
            sb.append(
                    ((N.charAt(i)-'0') * 4 +
                    (N.charAt(i+1) -'0') * 2 +
                    (N.charAt(i+2) - '0'))
            );
        }

        System.out.println(sb);

    }
}