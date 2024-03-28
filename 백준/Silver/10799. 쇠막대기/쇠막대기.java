import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') stack.push(input[i]);
            else {
                stack.pop();
                if (input[i - 1] == '(') answer += stack.size(); // 레이저
                else answer += 1; // 레이저 X
            }
        }

        System.out.println(answer);

    }
}