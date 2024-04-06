import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A', null, null);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertTree(root, value, left, right);
        }
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);

    }

    private static void insertTree(Node now, char value, char left, char right) {
        if (now.value == value) {
            now.left = (left == '.') ? null : new Node(left, null, null);
            now.right = (right == '.') ? null : new Node(right, null, null);
        }
        if (now.left != null) insertTree(now.left, value, left, right);
        if (now.right != null) insertTree(now.right, value, left, right);
    }

    // 루트 - 왼쪽 - 오른쪽
    private static void preOrder(Node now) {
        if (now == null) return;
        sb.append(now.value);
        preOrder(now.left);
        preOrder(now.right);
    }

    // 왼쪽 - 루트 - 오른쪽
    private static void inOrder(Node now) {
        if (now == null) return;
        inOrder(now.left);
        sb.append(now.value);
        inOrder(now.right);
    }

    // 왼쪽 - 오른쪽 - 루트
    private static void postOrder(Node now) {
        if (now == null) return;
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.value);
    }

}
