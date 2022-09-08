import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] original = {1,1,2,2,2,8};
        int[] input = new int[original.length];
        int[] result = new int[original.length];

        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        
        for(int i=0; i<strArr.length; i++){
            input[i] = Integer.valueOf(strArr[i]);
            result[i] = original[i] - input[i];
        }

        
        for(int i=0; i<original.length; i++){
            System.out.print(result[i] + " ");
        }

        scanner.close();

    }
}
