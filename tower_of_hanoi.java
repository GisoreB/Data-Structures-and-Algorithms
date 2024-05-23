import java.util.*;
public class tower_of_hanoi {
    public static void hanoi(int n, String from, String to, String via) {
        if(n == 1){
            System.out.println("Move disk 1 from " + from + " to " + to);
        }
        else{
            hanoi(n-1, from, via, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            hanoi(n-1, via, to, from);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        String from = "A";
        String to = "B";
        String via = "C";
        //calling hanoi() metod
        hanoi(n, from, via, to);
    }
}