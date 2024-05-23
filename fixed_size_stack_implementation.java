public class fixed_size_stack_implementation {

    final static int MAXSIZE = 8;
    public static int[] stack = new int[MAXSIZE];
    public static int top = -1;

    /* Check if the stack is empty */
    public static int isempty(){
        if(top == -1)
            return 1;
        else
            return 0;
    }

    /* Check if the stack is full */
    public static int isfull(){
        if(top == MAXSIZE)
            return 1;
        else
            return 0;
    }

    /* Function to return the topmost element in the stack */
    public static int peek(){
        return stack[top];
    }

    /* Function to delete from the stack */
    public static int pop(){
        int data = 0;
        if(isempty() != 1) {
            data = stack[top];
            top = top - 1;
            return data;
        } else
            System.out.print("Could not retrieve data, Stack is empty.");
        return data;
    }

    /* Function to insert into the stack */
    public static int push(int data){
        if(isfull() != 1) {
            top = top + 1;
            stack[top] = data;
        } else
            System.out.print("Could not insert data, Stack is full.");
        return data;
    }

    /* Main function */
    public static void main(String[] args){
        push(44);
        push(10);
        push(62);
        push(123);
        push(15);
        System.out.print("Element at top of the stack: " + peek());
        System.out.print("\nElements: ");
        // print stack data
        while(isempty() != 1) {
            int data = pop();
            System.out.print(data + " ");
        }
        boolean res1 = isfull() == 1;
        boolean res2 = true;
        System.out.print("\nStack full: " + res1);
        System.out.print("\nStack empty: " + res2);
    }
}
