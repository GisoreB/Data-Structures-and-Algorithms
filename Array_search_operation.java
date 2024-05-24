public class Array_search_operation {
    public static void main(String []args){

        // Initialize array.
        int[] studentId = new int[5];

        System.out.println("StudentID Array:");

        // Traverse through each array.
        for (int i = 0; i < 5; i++) {

            studentId[i] = i + 100;

            // Display the StudentId Array generated.
            System.out.println("studentId[" + i + "] = " + studentId[i]);

        }
        for (int i = 0; i < 5; i++) {
            if (studentId[i]== 104) {
                System.out.println("Student ID " + 102 +  " was found at index "  + i);
            }

        }

    }
}
