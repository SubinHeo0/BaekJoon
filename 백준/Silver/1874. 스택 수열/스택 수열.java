import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int start = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start) {
                while (nums[i] >= start) {
                    stack.push(start++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                if (stack.pop() > nums[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());

    }
}