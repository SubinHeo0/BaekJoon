import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarf = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            dwarf[i] = num;
            sum += num;
        }

        int target = sum - 100;
        int spy1 = -1;
        int spy2 = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == target) {
                    spy1 = dwarf[i];
                    spy2 = dwarf[j];
                    break;
                }
            }
            if (spy1 != -1) break;
        }

        for (int num : dwarf) {
            if ((num != spy1) && (num != spy2)) System.out.println(num);
        }

    }
}