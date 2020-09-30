import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumSortedArray {
    /*
    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.


Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
     */
    public static int[] twoSum(int[] nums, int target) {
        /* Brute Force Approach: Complexity O(n^2)
        for(int i=0,j=1; i<nums.length && j<nums.length;i++,j++) {
            if(nums[i] + nums[j] == target) {
                indicies_array[0]=i;
                indicies_array[1]=j;
            }
        }*/

        //Efficient: Complexity O(n)
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                System.out.println("[ " + numMap.get(complement) + ", " + (i+1) + " ]");
                return new int[] { numMap.get(complement), (i+1)};
            } else {
                numMap.put(nums[i], i+1);
            }
        }
        return new int[] {};
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



        int[] res = twoSum(arr, target);


        scanner.close();
    }
}
