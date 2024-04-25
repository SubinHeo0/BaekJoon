import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] dateArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] input = br.readLine().split(" ");
        int month = Integer.parseInt(input[0]);
        int date = Integer.parseInt(input[1]);

        int dateSum = 0;
        for (int i = 0; i < month; i++) {
            dateSum += dateArr[i];
        }
        dateSum += date;

        System.out.println(day[dateSum % 7]);

    }
}