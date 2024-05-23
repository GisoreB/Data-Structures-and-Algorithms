public interface tree_traversal_in_order {

    class Node {
        int data;
        Node leftChild;
        Node rightChild;
        public Node(int key) {
            data = key;
            leftChild = rightChild = null;
        }
    }
    public class TreeDataStructure {
        Node root = null;

        void inorder_traversal(Node node) {
            if (node != null) {
                inorder_traversal(node.leftChild);
                System.out.print(node.data + " ");
                inorder_traversal(node.rightChild);
            }
        }
        public static void main(String[] args) {
            TreeDataStructure tree = new TreeDataStructure();
            tree.root = new Node(27);
            tree.root.leftChild = new Node(12);
            tree.root.rightChild = new Node(3);
            tree.root.leftChild.leftChild = new Node(44);
            tree.root.leftChild.rightChild = new Node(17);
            tree.root.rightChild.leftChild = new Node(56);
            System.out.println("Inorder traversal: ");
            tree.inorder_traversal(tree.root);
        }
    }
}
