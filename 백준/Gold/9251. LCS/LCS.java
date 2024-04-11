import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        int strLen1 = str1.length();
        char[] strArr1 = new char[strLen1 + 1];
        for (int i = 1; i <= strLen1; i++) {
            strArr1[i] = str1.charAt(i - 1);
        }

        String str2 = br.readLine();
        int strLen2 = str2.length();
        char[] strArr2 = new char[strLen2 + 1];
        for (int i = 1; i <= strLen2; i++) {
            strArr2[i] = str2.charAt(i - 1);
        }

        int[][] dp = new int[strLen1 + 1][strLen2 + 1];

        for (int i = 1; i <= strLen1; i++) {
            for (int j = 1; j <= strLen2; j++) {
                if (strArr2[j] == strArr1[i]) { // 같은 인덱스의 값이 같을 때
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 대각선 값+1
                } else { // 행-1, 열-1 dp값 중 큰 값 가져오기
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strLen1][strLen2]);

    }
}
