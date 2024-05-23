public class Circular_linked_list_complete_implementation {

    static class Node {
        int data;
        int key;
        Node next;
        Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }
    public static class LinkedList {
        private Node head;
        private Node current;

        boolean isEmpty() {
            return head == null;
        }

        int length() {
            int length = 0;
            //if list is empty
            if (head == null) {
                return 0;
            }
            current = head.next;
            while (current != head) {
                length++;
                current = current.next;
            }
            return length;
        }

        //insert link at the first location
        void insertFirst(int key, int data) {
            //create a link
            Node link = new Node(key, data);
            if (isEmpty()) {
                head = link;
                head.next = head;
            } else {
                //point it to old first node
                link.next = head;
                //point first to new first node
                head = link;
            }
        }

        //delete first item
        Node deleteFirst() {
            if (head.next == head) {
                //save reference to first link
                Node tempLink = head;
                head = null;
                return tempLink;
            }
            Node tempLink = head;
            //mark next to first link as first
            head = head.next;
            //return the deleted link
            return tempLink;
        }

        //display the list
        void printList() {
            Node ptr = head;
            System.out.print("\n[ ");

            //start from the beginning
            if (head != null) {
                while (ptr.next != ptr) {
                    System.out.print("(" + ptr.key + "," + ptr.data + ") ");
                    ptr = ptr.next;
                }
            }
            System.out.print(" ]");
        }
    }
    public static void main(String [] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(1, 10);
        linkedList.insertFirst(2, 20);
        linkedList.insertFirst(3, 30);
        linkedList.insertFirst(4, 1);
        linkedList.insertFirst(5, 40);
        linkedList.insertFirst(6, 56);
        System.out.print("Original List: ");
        linkedList.printList();
        //print list
        while (!linkedList.isEmpty()) {
            Node temp = linkedList.deleteFirst();
            System.out.println("\nDeleted value: (" + temp.key + "," + temp.data + ")");
        }
        System.out.print("\nList after deleting all items: ");
        linkedList.printList();
    }
}
