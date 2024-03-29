import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
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