// Insertion array operation.
public class array_insertion_operation_ds {
    public static void main(String []args){

        // initialize employees' age data in an array of type int.
        int[] employee_age_display = new int[10];

        // Display empty employees' age data.
        System.out.println("Empty employees' age data as shown below: ");
        for (int i = 0; i < 10; i++) {

            // Display the empty employees' age array.
            System.out.println("employee_age_display: [" + i + "] = " + employee_age_display[i]);
        }
        System.out.println("Loading employees' age data updates on the real time database......");

        // Printing Array after Insertion
        System.out.println("Up-to-date employees' age data:");
        for(int i = 0; i < 10; i++) {
            employee_age_display[i] = i+10;
            System.out.println("employee_age_display: [" + i + "] = " + employee_age_display[i]);
        }

    }

}
