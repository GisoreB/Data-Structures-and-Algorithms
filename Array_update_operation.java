public class Array_update_operation {
    public static void main(String []args) {
        int[] LA = new int[5];
        int item = 15;
        System.out.println("The array elements are: ");
        for(int i = 0; i < 5; i++) {
            LA[i] = i + 2;
            System.out.println("LA[" + i + "] = " + LA[i]);
        }
        LA[3] = item;
        System.out.println("The array elements after updation are: ");
        for(int i = 0; i < 5; i++)
            System.out.println("LA[" + i + "] = " + LA[i]);
    }
}
