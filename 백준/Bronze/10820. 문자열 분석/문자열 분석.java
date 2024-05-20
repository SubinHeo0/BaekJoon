import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int[] arr = new int[4]; // 소문자, 대문자, 숫자, 공백
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isLowerCase(c)) arr[0]++;
                else if (Character.isUpperCase(c)) arr[1]++;
                else if (Character.isDigit(c)) arr[2]++;
                else arr[3]++;
            }

            for (int i : arr) {
                System.out.print(i + " ");
            }

            System.out.println();
        }

    }
}