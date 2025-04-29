import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<String,String[]> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        hm = new HashMap<>();
        for (int i = 0; i < loop; i++) {
            String[] nodes = br.readLine().split(" ");

            String[] childNodes = new String[2];

            // left
            if (!nodes[1].equals(".")) {
                childNodes[0] = nodes[1];
            }

            // right
            if (!nodes[2].equals(".")) {
                childNodes[1] = nodes[2];
            }

            hm.put(nodes[0], childNodes);
        }

        StringBuilder sb = new StringBuilder();
        preorder("A", sb);
        sb.append("\n");
        inorder("A", sb);
        sb.append("\n");
        postorder("A", sb);

        System.out.println(sb);

    }

    private static void preorder(String node, StringBuilder sb) {
        if (node == null) return;
        String[] childNode = hm.get(node);

        // parent
        sb.append(node);
        // left
        preorder(childNode[0], sb);
        // right
        preorder(childNode[1], sb);
    }

    private static void inorder(String node, StringBuilder sb) {
        if (node == null) return;
        String[] childNode = hm.get(node);

        // left
        inorder(childNode[0], sb);
        // parent
        sb.append(node);
        // right
        inorder(childNode[1], sb);
    }

    private static void postorder(String node, StringBuilder sb) {
        if (node == null) return;
        String[] childNode = hm.get(node);

        // left
        postorder(childNode[0], sb);
        // right
        postorder(childNode[1], sb);
        // parent
        sb.append(node);
    }

}
