import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int startIdx = 1;
        int endIdx = 1;
        int count = 1;
        int sum = 1;
        while (endIdx != N) {
            if (sum == N) {
                count++;
                endIdx++;
                sum += endIdx;
            } else if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else { //sum > N
                sum -= startIdx;
                startIdx++;
            }
        }
        System.out.println(count);
    }
}