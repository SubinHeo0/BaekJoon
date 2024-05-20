import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') stack.push(input.charAt(i));
            else {
                stack.pop();
                if (input.charAt(i - 1) == '(') cnt += stack.size(); // 레이저
                else cnt += 1;
            }
        }

        System.out.println(cnt);

    }
}