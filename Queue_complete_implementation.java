public class Queue_complete_implementation {

    final static int MAX = 6;
    static int intArray[] = new int[MAX];
    static int front = 0;
    static int rear = -1;
    static int itemCount = 0;
    public static int peek(){
        return intArray[front];
    }
    public static boolean isEmpty(){
        return itemCount == 0;
    }
    public static boolean isFull(){
        return itemCount == MAX;
    }
    public static int size(){
        return itemCount;
    }
    public static void insert(int data){
        if(!isFull()) {
            if(rear == MAX-1) {
                rear = -1;
            }
            intArray[++rear] = data;
            itemCount++;
        }
    }
    public static int removeData(){
        int data = intArray[front++];
        if(front == MAX) {
            front = 0;
        }
        itemCount--;
        return data;
    }
    public static void main(String [] args){
        /* insert 5 items */
        insert(3);
        insert(5);
        insert(9);
        insert(1);
        insert(12);
        insert(15);
        System.out.print("Queue size: " + size());
        System.out.print("\nQueue: ");
        for(int i = 0; i < MAX; i++){
            System.out.print(intArray[i] + " ");
        }
        if(isFull()) {
            System.out.print("\nQueue is full!");
        }

        // remove one item
        int num = removeData();
        System.out.print("\nElement removed: " + num);
        System.out.print("\nQueue size after deletion: " + size());
        System.out.print("\nElement at front: " + peek());
    }
}
