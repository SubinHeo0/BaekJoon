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
            return;
        }

        // now의 value와 mid값이 다르면 자식들을 타고 내려가면서 mid값과 같은 value를 지닌 노드를 찾아야함
        Node leftNode = now.left;
        Node rightNode = now.right;

        if (leftNode != null) { // 왼쪽부터 내려가면서 mid값과 같은 node를 찾음
            if (leftNode.value == mid) {// 같은 값을 찾았으면 트리에 삽입 삽입 하면 항상 리턴으로 걍 종료시킴
                leftNode.left = (left == '.') ? null : new Node(left);
                leftNode.right = (right == '.') ? null : new Node(right);
                return;
            }
            insertTree(leftNode, mid, left, right);
        }

        if (rightNode != null) { // 오른쪽으로 내려가면서 mid값과 같은 node를 찾음
            if (rightNode.value == mid) {// 같은 값을 찾았으면 트리에 삽입 삽입 하면 항상 리턴으로 걍 종료시킴
                rightNode.left = (left == '.') ? null : new Node(left);
                rightNode.right = (right == '.') ? null : new Node(right);
                return;
            }
            insertTree(rightNode, mid, left, right);
        }
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
