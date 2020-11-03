import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    /*
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int sumClosest=0;
        int diff= Integer.MAX_VALUE;

        for(int i = 0;i<n-2 ;i++) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int currSum = nums[i] + nums[j] + nums[k];

                if(currSum == target) return currSum;

                int currDiff = Math.abs(currSum - target);
                if(currDiff < diff) {
                    sumClosest = currSum;
                    diff = currDiff;
                }

                if(currSum>target) {
                    k--;
                }
                else {
                    j++;
                }
            }

        }
        return sumClosest;
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

        System.out.println("Enter the target sum: ");
        int target = scanner.nextInt();

        System.out.println(threeSumClosest(arr,target));

        scanner.close();
    }
}
