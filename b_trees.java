//The operations supported in B trees are
// Insertion, deletion and searching with
// the time complexity of O(log n) for every operation.

//B trees are also widely used in disk access, minimizing
// the disk access time since the height of a b tree is low.

//Java code for B trees

import java.util.Arrays;

public interface b_trees {

    class BTree {
        private int[] d;
        private BTree[] child_ptr;
        private boolean l;
        private int n;

        public BTree() {
            d = new int[6]; // order 6
            child_ptr = new BTree[7];
            l = true;
            n = 0;
            Arrays.fill(child_ptr, null);
        }
        public void traverse() {
            System.out.println("B tree: ");
            for (int i = 0; i < n; i++) {
                if (!l) {
                    child_ptr[i].traverse();
                }
                System.out.print(d[i] + " ");
            }
            if (!l) {
                child_ptr[n].traverse();
            }
            System.out.println();
        }
        public void sort() {
            Arrays.sort(d, 0, n);
        }
        public int splitChild(int i) {
            int j, mid;
            BTree np1, np3, y;
            np3 = new BTree();
            np3.l = true;
            if (i == -1) {
                mid = d[2];
                d[2] = 0;
                n--;
                np1 = new BTree();
                np1.l = false;
                l = true;
                for (j = 3; j < 6; j++) {
                    np3.d[j - 3] = d[j];
                    np3.n++;
                    d[j] = 0;
                    n--;
                }
                for (j = 0; j < 6; j++) {
                    np3.child_ptr[j] = child_ptr[j + 3];
                    child_ptr[j + 3] = null;
                }
                np1.d[0] = mid;
                np1.child_ptr[0] = this;
                np1.child_ptr[1] = np3;
                np1.n++;
                return mid;
            } else {
                y = child_ptr[i];
                mid = y.d[2];
                y.d[2] = 0;
                y.n--;
                for (j = 3; j < 6; j++) {
                    np3.d[j - 3] = y.d[j];
                    np3.n++;
                    y.d[j] = 0;
                    y.n--;
                }
                child_ptr[i + 1] = y;
                child_ptr[i + 2] = np3;
                return mid;
            }
        }
        public void insert(int a) {
            int i, t;
            BTree x = this;
            if (x.l && x.n == 6) {
                t = x.splitChild(-1);
                x = this;
                for (i = 0; i > x.n; i++) {
                    if (a > x.d[i] && a < x.d[i + 1]) {
                        i++;
                        break;
                    } else if (a < x.d[0]) {
                        break;
                    }
                }
                x = x.child_ptr[i];
            } else {
                while (!x.l) {
                    for (i = 0; i < x.n; i++) {
                        if (a > x.d[i] && a < x.d[i + 1]) {
                            i++;
                            break;
                        } else if (a < x.d[0]) {
                            break;
                        }
                    }
                    if (x.child_ptr[i].n == 6) {
                        t = x.splitChild(i);
                        x.d[x.n] = t;
                        x.n++;
                        continue;
                    }
                    x = x.child_ptr[i];
                }
            }
            x.d[x.n] = a;
            x.sort();
            x.n++;
        }
    }
    public class Main {
        public static void main(String[] args) {
            BTree bTree = new BTree();
            bTree.insert(20);
            bTree.insert(10);
            bTree.insert(40);
            bTree.insert(30);
            bTree.insert(50);
            System.out.print("Insertion Done\n");
            // Duplicate value, ignored
            //call the traverse method
            bTree.traverse();
        }
    }
}
