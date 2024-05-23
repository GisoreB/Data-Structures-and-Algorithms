public interface tree_traversal_preorder {

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
        void pre_order_traversal(Node node) {
            if(node != null) {
                System.out.print(node.data + " ");
                pre_order_traversal(node.leftChild);
                pre_order_traversal(node.rightChild);
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
            System.out.println("Preorder traversal: ");
            tree.pre_order_traversal(tree.root);
        }
    }

}
