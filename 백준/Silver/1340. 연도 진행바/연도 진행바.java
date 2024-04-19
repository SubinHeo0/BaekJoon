import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ===입력===
        String[] split = br.readLine().split(", ");

        String monthAndDate = split[0]; // May 10
        String month = monthAndDate.split(" ")[0];
        int date = Integer.parseInt(monthAndDate.split(" ")[1]);

        String yearAndTime = split[1]; // 1981 00:31
        String[] yearSpl = yearAndTime.split(" ");
        int year = Integer.parseInt(yearSpl[0]);
        int hour = Integer.parseInt(yearSpl[1].split(":")[0]);
        int min = Integer.parseInt(yearSpl[1].split(":")[1]);

        // ===계산===
        int[] dateArr = checkYear(year);
        int dateSum = 0;

        // 1월 ~ 입력 월의 전 월까지의 합
        String[] monthArr = {"0", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < 12; i++) {
            dateSum += dateArr[i];
            if (month.equals(monthArr[i + 1])) break;
        }
        dateSum += date - 1; // 5월 10(date)일이면 5월 9일까지 더하기

        // 총 시간(분 단위)
        // 1일 = 60분 * 24 = 1440
        int sum = (dateSum * 1440) + (hour * 60) + min;

        // 1년(분 단위)
        int total = (dateArr[2] == 28) ? 525600 : 527040;

        System.out.println((double) sum / total * 100);


    }

    // 평년|윤년에 따른 각 달의 날짜
    private static int[] checkYear(int year) {
        int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) date[2] = 29;
        return date;
    }
}
