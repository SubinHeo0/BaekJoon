import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            sum += num;
        }

        if (sum == 180) {
            if (set.size() == 1) System.out.println("Equilateral");
            else if (set.size() == 2) System.out.println("Isosceles");
            else System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }

    }
}