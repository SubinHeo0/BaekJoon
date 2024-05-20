import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                if (c + 13 > 'Z') bw.write(('A' - 1) + ((c + 13) - 'Z'));
                else bw.write(c + 13);
            } else if (Character.isLowerCase(c)) {
                if (c + 13 > 'z') bw.write(('a' - 1) + ((c + 13) - 'z'));
                else bw.write(c + 13);
            } else bw.write(c);
        }

        bw.flush();

    }
}