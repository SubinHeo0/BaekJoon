import java.io.*;
import java.util.*;

public class Main {

    private static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Student(name, korean, english, math));
        }

        // 1. 국어 내림차순
        // 2. 영어 오름차순
        // 3. 수학 내림차순
        // 4. 이름 오름차순
        Collections.sort(students, (o1, o2) -> {
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) return o1.name.compareTo(o2.name);
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }
            return o2.korean - o1.korean;
        });

        for (Student student : students) {
            bw.write(student.name + "\n");
        }

        bw.flush();

    }
}
