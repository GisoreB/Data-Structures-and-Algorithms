public class Linked_list_complete_implementation {
    public static class Linked_List {
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
            node lk = new node(data);;

            // point it to old first node
            lk.next = head;

            //point first to new first node
            head = lk;
        }
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
        static void insertafternode(node list) {
            node lk = new node(33);
            lk.next = list.next;
            list.next = lk;
        }
        static void deleteatbegin() {
            head = head.next;
        }
        static void deleteatend() {
            node linkedlist = head;
            while (linkedlist.next.next != null)
                linkedlist = linkedlist.next;
            linkedlist.next = null;
        }
        static void deletenode() {
            node temp = head;
            node prev = null;
            if (temp != null && temp.data == 12) {
                head = temp.next;
                return;
            }

            // Find the key to be deleted
            while (temp != null && temp.data != 12) {
                prev = temp;
                temp = temp.next;
            }

            // If the key is not present
            if (temp == null) return;

            // Remove the node
            prev.next = temp.next;
        }
        static int searchlist() {
            node temp = head;
            while(temp != null) {
                if (temp.data == 16) {
                    temp=temp.next;
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String [] args){
        int k=0;
        Linked_List.insertatbegin(12);
        Linked_List.insertatbegin(22);
        Linked_List.insertatend(30);
        Linked_List.insertatend(44);
        Linked_List.insertatbegin(50);
        Linked_List.insertafternode(Linked_List.head.next.next);
        System.out.print("Linked List: ");

        // print list
        Linked_List.printList();
        Linked_List.deleteatbegin();
        Linked_List.deleteatend();
        Linked_List.deletenode();
        System.out.print("\nLinked List after deletion: ");

        // print list
        Linked_List.printList();
        Linked_List.insertatbegin(4);
        Linked_List.insertatbegin(16);
        System.out.print("\nUpdated Linked List: ");
        Linked_List.printList();
        k = Linked_List.searchlist();
        if (k == 1)
            System.out.print("\nElement is found");
        else
            System.out.print("\nElement is not present in the list");
    }

}
