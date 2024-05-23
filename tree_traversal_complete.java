public interface tree_traversal_complete {

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
            if(node != null) {
                inorder_traversal(node.leftChild);
                System.out.print(node.data + " ");
                inorder_traversal(node.rightChild);
            }
        }
        void pre_order_traversal(Node node) {
            if(node != null) {
                System.out.print(node.data + " ");
                pre_order_traversal(node.leftChild);
                pre_order_traversal(node.rightChild);
            }
        }
        void post_order_traversal(Node node) {
            if(node != null) {
                post_order_traversal(node.leftChild);
                post_order_traversal(node.rightChild);
                System.out.print(node.data + " ");
            }
        }
        public static void main(String args[]) {
            TreeDataStructure tree = new TreeDataStructure();
            tree.root = new Node(27);
            tree.root.leftChild = new Node(12);
            tree.root.rightChild = new Node(3);
            tree.root.leftChild.leftChild = new Node(44);
            tree.root.leftChild.rightChild = new Node(17);
            tree.root.rightChild.leftChild = new Node(56);
            System.out.println("Inorder traversal: ");
            tree.inorder_traversal(tree.root);
            System.out.println("\nPreorder traversal: ");
            tree.pre_order_traversal(tree.root);
            System.out.println("\nPost order traversal: ");
            tree.post_order_traversal(tree.root);
        }
    }

}
