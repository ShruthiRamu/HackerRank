import java.io.IOException;
import java.util.Scanner;

public class pivotIndex {
    /*
    Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
     */
    public static int pivotIndex(int[] nums) {
        int sumLeft=0;
        int sum=0;
        for (int num : nums) {
            sum += num;
        }

        for(int i=0;i<nums.length;i++){
            int sumRight = sum-sumLeft-nums[i];
            if(sumLeft==sumRight) return i;
            sumLeft+=nums[i];
        }
        return -1;
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



        int res = pivotIndex(arr);


        scanner.close();
    }
}
