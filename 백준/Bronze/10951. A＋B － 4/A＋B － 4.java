import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (scanner.hasNext()) { // 다음 줄에 입력이 있을 때 반복
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            bw.write(x + y + "\n");
        }

        scanner.close();
        bw.flush();
        bw.close();

    }
}
