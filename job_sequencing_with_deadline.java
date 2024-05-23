import java.util.*;

public class job_sequencing_with_deadline {

    // Each job has a unique-id,profit and deadline
    char id;
    int deadline, profit;
    // Constructors
    public job_sequencing_with_deadline() {}
    public job_sequencing_with_deadline(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
    // Function to schedule the jobs take 2 arguments
    // arraylist and no of jobs to schedule
    void printJobScheduling(ArrayList<job_sequencing_with_deadline> arr, int t) {
        // Length of array
        int n = arr.size();
        // Sort all jobs according to decreasing order of
        // profit
        Collections.sort(arr,(a, b) -> b.profit - a.profit);
        // To keep track of free time slots
        boolean[] result = new boolean[t];
        // To store result (Sequence of jobs)
        char[] job = new char[t];
        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (Note that we
            // start from the last possible slot)
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                // Free slot found
                if (!result[j]) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
        // Print the sequence
        for (char jb : job)
            System.out.print(jb + " ");
        System.out.println();
    }
    // Driver code
    public static void main(String[] args) {
        ArrayList<job_sequencing_with_deadline> arr = new ArrayList<job_sequencing_with_deadline>();
        arr.add(new job_sequencing_with_deadline('a', 2, 100));
        arr.add(new job_sequencing_with_deadline('b', 2, 20));
        arr.add(new job_sequencing_with_deadline('c', 1, 40));
        arr.add(new job_sequencing_with_deadline('d', 3, 35));
        arr.add(new job_sequencing_with_deadline('e', 1, 25));
        // Function call
        System.out.println("Following is maximum profit sequence of Jobs: ");
        job_sequencing_with_deadline job = new job_sequencing_with_deadline();
        // Calling function
        job.printJobScheduling(arr, 3);
    }

}
