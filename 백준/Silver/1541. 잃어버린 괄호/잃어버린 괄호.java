import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 그리디 알고리즘: -를 기준으로 쪼개서 합을 구한 뒤 전체 합계에서 빼기 진행
        String[] subArr = line.split("-"); //55 50+40
        int answer = 0;
        for (int i = 0; i < subArr.length; i++) {
            int tmpResult = sum(subArr[i]);
            if (i == 0) answer += tmpResult;
            else answer -= tmpResult;
        }
        System.out.println(answer);
    }

    // +를 기준으로 쪼개서 합을 구함
    private static int sum(String line) {
        int sum = 0;
        String[] numArr = line.split("[+]");
        for (int i = 0; i < numArr.length; i++) {
            sum += Integer.parseInt(numArr[i]);
        }
        return sum;
    }
}