import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A');
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char mid = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertTree(root, mid, left, right);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);

    }

    private static void insertTree(Node now, char mid, char left, char right) {
        if (now.value == mid) {
            now.left = (left == '.') ? null : new Node(left);
            now.right = (right == '.') ? null : new Node(right);
        }
        if(now.left != null) insertTree(now.left, mid, left, right);
        if(now.right != null) insertTree(now.right, mid, left, right);
    }

    // 루트, 왼쪽, 오른쪽
    private static void preOrder(Node now) {
        if (now == null) return;
        sb.append(now.value);
        preOrder(now.left);
        preOrder(now.right);
    }

    // 왼쪽, 루트, 오른쪽
    private static void inOrder(Node now) {
        if (now == null) return;
        inOrder(now.left);
        sb.append(now.value);
        inOrder(now.right);

    }

    // 왼쪽, 오른쪽, 루트
    private static void postOrder(Node now) {
        if (now == null) return;
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.value);
    }
}
