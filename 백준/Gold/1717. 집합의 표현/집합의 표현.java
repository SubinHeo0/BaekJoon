import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수
        parent = new int[n + 1];
        // 자기자신으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        // 연산 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (question == 0) { // union
                union(num1, num2);
            } else { // find
                if (find(num1) == find(num2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }

    private static void union(int num1, int num2) {
        // 각각의 부모를 찾아서 그 부모들을 연결
        int parent1 = find(num1);
        int parent2 = find(num2);
        if (parent1 != parent2) parent[parent2] = parent1;
    }

    /**
     * 최종 부모 찾는 함수
     *
     * @param num: parent[] 인덱스값
     * @return 최종 부모 인덱스값(최종 부모: 인덱스값==value값)
     */
    private static int find(int num) { // num은 현재 parent배열의 인덱스값
        // 인덱스값과 value값이 일치하면 찐 부모
        if (num == parent[num]) return num;
        // 최종 부모가 아니면 value값을 index값으로 다시 find
        // 재귀로 최종의 부모를 찾으면서 빠져나올때 부모인덱스로 value값 수정
        return parent[num] = find(parent[num]);
    }
}