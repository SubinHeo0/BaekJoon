import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        stack.push(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                stack.pop();
                if (input.charAt(i - 1) == '(') count += stack.size(); // 레이저
                else count += 1; // 레이저X
            } else {
                stack.push(input.charAt(i));
            }
        }

        System.out.println(count);

    }
}