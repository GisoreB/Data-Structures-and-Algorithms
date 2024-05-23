public class fractional_knapsack_problem {

    static int n = 5;
    static int p[] = {3, 3, 2, 5, 1};
    static int w[] = {10, 15, 10, 12, 8};
    static int W = 10;
    public static void main(String[] args) {
        int cur_w;
        float tot_v = 0;
        int i, maxi;
        int[] used = new int[10];
        for (i = 0; i < n; ++i)
            used[i] = 0;
        cur_w = W;
        while (cur_w > 0) {
            maxi = -1;
            for (i = 0; i < n; ++i)
                if ((used[i] == 0) &&
                        ((maxi == -1) || ((float)w[i]/p[i] > (float)w[maxi]/p[maxi])))
                    maxi = i;
            used[maxi] = 1;
            cur_w -= p[maxi];
            tot_v += w[maxi];
            if (cur_w >= 0)
                System.out.println("Added object " + maxi + 1 + " (" + w[maxi] + "," + p[maxi] + ") completely in the bag. Space left: " + cur_w);
            else {
                System.out.println("Added " + ((int)((1 + (float)cur_w/p[maxi]) * 100)) + "% (" + w[maxi] + "," + p[maxi] + ") of object " + (maxi + 1) + " in the bag.");
                tot_v -= w[maxi];
                tot_v += (1 + (float)cur_w/p[maxi]) * w[maxi];
            }
        }
        System.out.println("Filled the bag with objects worth " + tot_v);
    }

}


//To explain this problem a little easier, consider a test with 12 questions, 10 marks each,
//out of which only 10 should be attempted to get the maximum mark of 100. The test taker now must
//calculate the highest profitable questions – the one that he’s confident in – to achieve the maximum mark.
//        However, he cannot attempt all the 12 questions since there will not be any extra marks awarded for
//those attempted answers. This is the most basic real-world application of the knapsack problem.