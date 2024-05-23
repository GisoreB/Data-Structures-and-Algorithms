public class Linked_list_search_operation {

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

        // Searching an element.
        static int searchlist(int key) {
            node temp = head;
            while(temp != null) {
                if (temp.data == key) {
                    return 1;
                }
                temp=temp.next;
            }
            return 0;
        }

    }
    public static void main(String [] args){

        // Search engine.
        int k;

        Linked_List.insertatbegin(22);
        Linked_List.insertatbegin(30);
        Linked_List.insertatbegin(44);
        Linked_List.insertatbegin(50);
        Linked_List.insertatbegin(33);

        System.out.print("Linked List: ");

        // print list
        Linked_List.printList();

        // Search implementation.
        int ele = 84;
        System.out.print("\nElement to be searched is: " + ele);
        k = Linked_List.searchlist(ele);

        if (k == 1)
            System.out.println("\nElement is found ");
        else
            System.out.println("\nElement is not found in the list");

    }
}
