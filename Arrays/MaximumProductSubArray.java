import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumProductSubArray {
    /*
    Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
    which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */
    public static int maxProduct(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int max = 1, min = 1;

        for(int num : nums) {
            //multiply num with both min and max calculated so far, because either of them can become the new min
            //ex: min = 2, max = 4 and num = -3; min = -12 not -6
            int local_min = Math.min(min*num, max*num);
            int local_max = Math.max(min*num, max*num); //similarly for max

            //update min and max
            min = Math.min(num, local_min);
            max = Math.max(num, local_max);
            //if either min or max is assigned num, we can assume start of a new contiguous sub-array,
            //ex :  [-10,0,2] max is 0 at second item, and is followed by a postive num.

            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
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

        int res = maxProduct(arr);
        System.out.println(res);

        scanner.close();
    }
}
