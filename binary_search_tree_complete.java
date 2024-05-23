import java.util.Scanner;

public interface binary_search_tree_complete {

    class BSTNode {
        BSTNode left, right;
        int data;
        public BSTNode(int n) {
            left = null;
            right = null;
            data = n;
        }
    }
    public class BST {
        static BSTNode root;
        public BST() {
            root = null;
        }
        public boolean isEmpty() {
            return root == null;
        }
        private BSTNode insert(BSTNode node, int data) {
            if(node == null)
                node = new BSTNode(data);
            else {
                if(data <= node.data)
                    node.left = insert(node.left, data);
                else
                    node.right = insert(node.right, data);
            }
            return node;
        }
        public void delete(int k) {
            if(isEmpty ())
                System.out.println("TREE EMPTY");
            else if(!search(k))
                System.out.println("SORRY " + k + " IS NOT PRESENT");
            else {
                root=delete(root,k);
                System.out.println(k + " DELETED FROM THE TREE");
            }
        }
        public BSTNode delete(BSTNode root, int k) {
            BSTNode p, p2, n;
            if(root.data == k) {
                BSTNode lt, rt;
                lt = root.left;
                rt = root.right;
                if(lt == null && rt == null) {
                    return null;
                } else if(lt == null) {
                    p = rt;
                    return p;
                } else if(rt == null) {
                    p = lt;
                    return p;
                } else {
                    p2 = rt;
                    p = rt;
                    while(p.left != null)
                        p = p.left;
                    p.left = lt;
                    return p2;
                }
            }
            if (k < root.data) {
                n = delete(root.left, k);
                root.left = n;
            } else {
                n = delete(root.right, k);
                root.right = n;
            }
            return root;
        }
        public boolean search(int val) {
            return search(root, val);
        }
        private boolean search(BSTNode r, int val) {
            boolean found = false;
            while ((r != null) && !found) {
                int rval = r.data;
                if(val < rval)
                    r = r.left;
                else if (val > rval)
                    r = r.right;
                else {
                    found = true;
                    break;
                }
                found = search(r, val);
            }
            return found;
        }
        void printTree(BSTNode node, String prefix) {
            if(node == null)
                return;
            printTree(node.left , " " + prefix);
            System.out.println(prefix + "--" + node.data);
            printTree(node.right , prefix + " ");
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            BST bst = new BST();
            root = bst.insert(root, 55);
            root = bst.insert(root, 20);
            root = bst.insert(root, 90);
            root = bst.insert(root, 80);
            root = bst.insert(root, 50);
            root = bst.insert(root, 35);
            root = bst.insert(root, 15);
            root = bst.insert(root, 65);
            bst.printTree(root, " ");
            bst.delete(55);
            System.out.println("Element found = " + bst.search(80));
            System.out.println("Is Tree Empty? " + bst.isEmpty());
        }
    }

}
