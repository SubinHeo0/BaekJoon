import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine()); // 23
        // 64로 만들 수 있는 나무 막대기 길이
        List<Integer> bar = new ArrayList<>(); // 64 32 16 8 4 2 1
        int num = 64;
        while (num > 0) {
            bar.add(num);
            num /= 2;
        }

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < bar.size(); i++) {
            int size = bar.get(i); // 8
            if (size > X) continue;

            if (sum + size <= X) {
                sum += size; // 16
                cnt++; // 1
            } else {
                continue;
            }

            if (sum == X) break;
        }

        System.out.println(cnt);

    }
}