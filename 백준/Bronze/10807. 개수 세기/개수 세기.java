import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];

        String[] numStr = br.readLine().split(" ");
        for (int i = 0; i < numStr.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int find = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == find) count++;
        }

        System.out.println(count);

    }
}
