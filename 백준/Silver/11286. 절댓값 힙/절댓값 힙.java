import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> {
            int firstAbs = Math.abs(num1);
            int secondAbs = Math.abs(num2);
            // 절댓값이 같은 경우 음수 우선
            if (firstAbs == secondAbs) {
                return num1 > num2 ? 1 : -1;
            }
            // 절댓값이 작은 데이터 우선
            return firstAbs - secondAbs;
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.size() == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(input);
            }
        }

    }
}