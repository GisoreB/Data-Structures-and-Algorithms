// Java program for Recursion Data Structure

public class recursion_basics {
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0)
            return 1;
        // Recursive case: multiply n with factorial of (n-1)
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        //Case 1
        int number = 12;
        System.out.println("Number is: " + number);
        //Case 2
        int result = factorial(number);
        //print the output
        System.out.println("Factorial of " + number + " is: " + result);
    }
}