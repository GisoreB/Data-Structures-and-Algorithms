public class Doubly_linked_list_complete_implementation {

    static class Node {
        int data;
        int key;
        Node next;
        Node prev;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static class DoublyLinkedList {
        Node head;
        Node last;

        boolean isEmpty() {
            return head == null;
        }

        void displayForward() {
            Node ptr = head;
            System.out.print("[ ");
            while (ptr != null) {
                System.out.print("(" + ptr.key + "," + ptr.data + ") ");
                ptr = ptr.next;
            }
            System.out.println("]");
        }

        void displayBackward() {
            Node ptr = last;
            System.out.print("[ ");
            while (ptr != null) {
                System.out.print("(" + ptr.key + "," + ptr.data + ") ");
                ptr = ptr.prev;
            }
            System.out.println("]");
        }

        void insertFirst(int key, int data) {
            Node link = new Node(key, data);
            if (isEmpty()) {
                last = link;
            } else {
                head.prev = link;
            }
            link.next = head;
            head = link;
        }

        void insertLast(int key, int data) {
            Node link = new Node(key, data);
            if (isEmpty()) {
                last = link;
            } else {
                last.next = link;
                link.prev = last;
            }
            last = link;
        }

        void deleteFirst() {
            if (isEmpty()) {
                return;
            }
            Node tempLink = head;
            if (head.next == null) {
                last = null;
            } else {
                head.next.prev = null;
            }
            head = head.next;
        }

        void deleteLast() {
            if (isEmpty()) {
                return;
            }
            Node tempLink = last;
            if (head.next == null) {
                head = null;
            } else {
                last.prev.next = null;
            }
            last = last.prev;
        }

        void delete() {
            Node current = head;
            Node previous = null;
            if (head == null) {
                return;
            }
            while (current.key != 4) {
                if (current.next == null) {
                    return;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == head) {
                head = head.next;
            } else {
                current.prev.next = current.next;
            }
            if (current == last) {
                last = current.prev;
            } else {
                current.next.prev = current.prev;
            }
        }

        void insertAfter() {
            Node current = head;
            if (head == null) {
                return;
            }
            while (current.key != 4) {
                if (current.next == null) {
                    return;
                } else {
                    current = current.next;
                }
            }
            Node newLink = new Node(7, 13);
            if (current == last) {
                newLink.next = null;
                last = newLink;
            } else {
                newLink.next = current.next;
                current.next.prev = newLink;
            }
            newLink.prev = current;
            current.next = newLink;
        }
    }
    public static void main(String [] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(1, 10);
        dll.insertFirst(2, 20);
        dll.insertFirst(3, 30);
        dll.insertFirst(4, 1);
        dll.insertFirst(5, 40);
        dll.insertFirst(6, 56);
        System.out.println("List (First to Last):");
        dll.displayForward();
        System.out.println();
        System.out.println("List (Last to First):");
        dll.displayBackward();
        System.out.println("List, after deleting first record:");
        dll.deleteFirst();
        dll.displayForward();
        System.out.println("List, after deleting last record:");
        dll.deleteLast();
        dll.displayForward();
        System.out.println("List, insert after key(4):");
        dll.insertAfter();
        dll.displayForward();
        System.out.println("List, after delete key(4):");
        dll.delete();
        dll.displayForward();
    }
}
