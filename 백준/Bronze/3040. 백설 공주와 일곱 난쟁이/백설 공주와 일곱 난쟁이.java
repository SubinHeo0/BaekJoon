import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarf = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            total += dwarf[i];
        }

        int key = total - 100; // 초과
        int spy1 = -1;
        int spy2 = -1;
        boolean isExist = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == key) {
                    isExist = true;
                    spy1 = j;
                    break;
                }
            }
            if (isExist) {
                spy2 = i;
                break;
            }
        }

        // 스파이 빼고 출력
        for (int i = 0; i < 9; i++) {
            if ((i == spy1) || (i == spy2)) continue;
            System.out.println(dwarf[i]);
        }

    }
}