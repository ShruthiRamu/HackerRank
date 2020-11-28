import java.io.IOException;
import java.util.Scanner;

public class countNumOfTeams {

    /*
    There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:

Input: rating = [1,2,3,4]
Output: 4
     */
    public static int numTeams(int[] rating) {
        int len = rating.length;
        int count=0;

        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                for(int k=j+1;k<len;k++){
                    if((rating[i]<rating[j] && rating[j]<rating[k])
                            || (rating[i]>rating[j] && rating[j]>rating[k])) {
                        //System.out.println
                        count++;
                    }
                }
            }
        }
        return count;

        /*
        int countTeams = 0;

        for (int i = 0; i < rating.length; i++) {
            int lesserCount = 0;
            int greaterCount = 0;

            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    ++lesserCount;
                }
            }

            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    ++greaterCount;
                }
            }

            countTeams += lesserCount * greaterCount;
            countTeams += (i - lesserCount) * (rating.length - 1 - i - greaterCount);
        }

        return countTeams;
         */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int target;
        System.out.println("Enter the target sum ");
        target = scanner.nextInt();



        System.out.println(numTeams(arr));


        scanner.close();
    }
}
