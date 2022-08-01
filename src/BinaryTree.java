public class BinaryTree {
    Node root;

    public void createNode(int parent[], int i, Node created[]) {
        if (created[i] != null)
            return;
        created[i] = new Node(i);

        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);

        Node p = created[parent[i]];

        if (p.left == null)
            p.left = created[i];
        else
            p.right = created[i];
    }

    Node createTree(int parent[], int n) {
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;
        for (int i = 0; i < n; i++)
            createNode(parent, i, created);
        return root;
    }

    void newLine() {
        System.out.println("");
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
}