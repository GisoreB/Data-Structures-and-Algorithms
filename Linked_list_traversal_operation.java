public class Linked_list_traversal_operation {
    public static class Linked_List {
        static class node {
            int data;
            node next;

            node(int value) {
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
            while (p != null) {
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
    }
    public static void main(String[] args){

        // Adding data.

        Linked_List.insertatbegin(12);
        Linked_List.insertatbegin(22);
        Linked_List.insertatbegin(30);
        Linked_List.insertatbegin(44);
        Linked_List.insertatbegin(50);
        Linked_List.insertatbegin(33);

        System.out.print("Linked List: ");

        // print list
        Linked_List.printList();
    }
}
