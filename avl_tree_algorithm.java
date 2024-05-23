import java.util.*;
import java.io.*;

public interface avl_tree_algorithm {

    class Node {
        int key, height;
        Node left, right;
        Node (int d) {
            key = d;
            height = 1;
        }
    }
    public class AVLTree {
        Node root;
        int height (Node N) {
            if (N == null)
                return 0;
            return N.height;
        }
        int max (int a, int b) {
            return Math.max(a, b);
        }
        Node rightRotate (Node y) {
            Node x = y.left;
            Node T2 = x.right;
            x.right = y;
            y.left = T2;
            y.height = max (height (y.left), height (y.right)) + 1;
            x.height = max (height (x.left), height (x.right)) + 1;
            return x;
        }
        Node leftRotate (Node x) {
            Node y = x.right;
            Node T2 = y.left;
            y.left = x;
            x.right = T2;
            x.height = max (height (x.left), height (x.right)) + 1;
            y.height = max (height (y.left), height (y.right)) + 1;
            return y;
        }
        int getBalance (Node N) {
            if (N == null)
                return 0;
            return height (N.left) - height (N.right);
        }
        Node insert (Node node, int key) {
            if (node == null)
                return (new Node (key));
            if (key < node.key)
                node.left = insert (node.left, key);
            else if (key > node.key)
                node.right = insert (node.right, key);
            else
                return node;
            node.height = 1 + max (height (node.left), height (node.right));
            int balance = getBalance (node);
            if (balance > 1 && key < node.left.key)
                return rightRotate (node);
            if (balance < -1 && key > node.right.key)
                return leftRotate (node);
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate (node.left);
                return rightRotate (node);
            }
            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate (node.right);
                return leftRotate (node);
            }
            return node;
        }
        void printTree(Node root){
            if (root == null)
                return;
            printTree(root.left);
            System.out.print(root.key + " ");
            printTree(root.left);
        }
        public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 11);
            tree.root = tree.insert(tree.root, 12);
            tree.root = tree.insert(tree.root, 13);
            tree.root = tree.insert(tree.root, 14);
            tree.root = tree.insert(tree.root, 15);
            System.out.println("AVL Tree: ");
            tree.printTree(tree.root);

        }
    }

}
