

public class Linked_list_insertion_operation {
    static class node {
        int data;
        node next;
        node (int value) {
            data = value;
            next = null;
        }
    }
    static node head;

    // display the list
    static void printList() {
        node p = head;
        System.out.print("\n[");

        //start from the beginning
        while(p != null) {
            System.out.print(" " + p.data + " ");
            p = p.next;
        }
        System.out.print("]");
    }

    //insertion at the beginning
    static void insertatbegin(int data) {

        //create a link
        node lk = new node(data);

        // point it to old first node
        lk.next = head;

        //point first to new first node
        head = lk;
    }

    // Inserting at the end operation.
    static void insertatend(int data) {

        //create a link
        node lk = new node(data);
        node linkedlist = head;

        // point it to old first node
        while(linkedlist.next != null)
            linkedlist = linkedlist.next;

        //point first to new first node
        linkedlist.next = lk;
    }

    // Inserting between nodes operation.
    static void insertafternode(node list, int data) {
        node lk = new node(data);
        lk.next = list.next;
        list.next = lk;
    }
    // Deleting at the beginning operation.
    static void deleteatbegin() {
        head = head.next;
    }
    // Deletion at Ending.
    static void deleteatend() {
        node linkedlist = head;
        while (linkedlist.next.next != null)
            linkedlist = linkedlist.next;
        linkedlist.next = null;
    }

    // Deletion at a Given Position.
    static void deletenode(int key) {
        node temp = head;
        node prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Find the key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If the key is not present
        if (temp == null) return;

        // Remove the node
        prev.next = temp.next;
    }

    public static void main(String[] args) {
        int k=0;
        insertatbegin(12);
        insertatbegin(22);
        insertatbegin(30);
        insertatbegin(44);
        insertatbegin(50);
        insertatend(22);
        insertatend(30);
        insertatend(44);
        insertatend(50);
        insertafternode(head.next, 50);
        insertafternode(head.next.next, 33);
        System.out.print("Linked List: ");
        // print list
        printList();
//       deleteatbegin();
//        deleteatend();
        deletenode(44);
        System.out.print("\nLinked List after deletion: ");

        // print list
     printList();
    }
}
