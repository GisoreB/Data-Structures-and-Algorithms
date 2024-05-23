public class Linked_list_reversal_operation {
    public static class Linked_List {
        static Node head;

        static class Node {
            int data;
            Node next;

            Node(int value) {
                data = value;
                next = null;
            }
        }

        // display the list
        static void printList(Node node) {
            System.out.print("\n[");

            //start from the beginning
            while (node != null) {
                System.out.print(" " + node.data + " ");
                node = node.next;
            }
            System.out.print("]");
        }

        static Node reverseList(Node head) {
            Node prev = null;
            Node cur = head;
            Node temp = null;
            while (cur != null) {
                temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            head = prev;
            return head;
        }

        public static void main(String[] args) {
            Linked_List list = new Linked_List();
            head = new Node(33);
            head.next = new Node(50);
            head.next.next = new Node(44);
            head.next.next.next = new Node(22);
            head.next.next.next.next = new Node(12);
            head.next.next.next.next.next = new Node(45);
            System.out.print("Linked List: ");

            // print list
            printList(head);
            head = reverseList(head);
            System.out.print("\nReversed linked list ");
            printList(head);
        }
    }
}