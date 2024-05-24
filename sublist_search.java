import java.io.*;

public class sublist_search {

    public static class Node {
        int data;
        Node next;
    }
    public static Node newNode(int key) {
        Node val = new Node();
        val.data= key;
        val.next = null;
        return val;
    }
    public static boolean sub_list_search(Node list_ptr, Node sub_ptr) {
        Node ptr1 = list_ptr, ptr2 = sub_ptr;
        if (list_ptr == null && sub_ptr == null)
            return true;
        if (sub_ptr == null || list_ptr == null)
            return false;
        while (list_ptr != null) {
            ptr1 = list_ptr;
            while (ptr2 != null) {
                if (ptr1 == null)
                    return false;
                else if (ptr2.data == ptr1.data) {
                    ptr2 = ptr2.next;
                    ptr1 = ptr1.next;
                } else
                    break;
            }
            if (ptr2 == null)
                return true;
            ptr2 = sub_ptr;
            list_ptr = list_ptr.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node list = newNode(2);
        list.next = newNode(5);
        list.next.next = newNode(3);
        list.next.next.next = newNode(3);
        list.next.next.next.next = newNode(6);
        list.next.next.next.next.next = newNode(7);
        list.next.next.next.next.next.next = newNode(0);
        Node sub_list = newNode(3);
        sub_list.next = newNode(6);
        sub_list.next.next = newNode(7);
        boolean res = sub_list_search(list, sub_list);
        if (res){
            System.out.print("Is the sublist present in the list? " + res);
        }
    }
}
