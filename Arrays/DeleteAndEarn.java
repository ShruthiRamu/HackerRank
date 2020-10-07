import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteAndEarn {

    /*
    Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation:
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.


Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation:
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.


Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
     */
    /*
     // This question can convert to HouseRobber problem
    // If you rob nums[i], then you can not rob nums[i-1] and nums[i+1]
    // You can not rob two adjacent houses(numbers)
    // First thing you need to do is to sum them up for the particular number

    // Subproblem=
    // robbery of current house + loot from houses before the previous one
    // OR loot from the previous house robbery and any loot captured before that
    // rob(i) = Math.max( rob(i - 2) + currentValue, rob(i - 1) )

	// for example:
	// After we sum up fpr each particular number, we can get
	// sum1,  sum2,  sum3,  sum4, sum5...
	//    1,     6,     3,     8,    10

	// if we reach to sum3,  prev1 = 6 , prev2=1
	// (prev2+sum3)=4  <  prev1=6
	// so new prev1 = 6,  new prev2 = prev1 =6
    // if we reach to sum4, (prev2+sum4)=6+8=14 < prev1=6
	// so new prev1 =14 , new prev2=prev1=6
	// if we reahc to sum5, (prev2+sum5)=6+10=16 > prev1=14
	// finally, new prev1=16 which is the largest sum
	// the key is to compare previous sum(prev1) and the sum before prev1(prev2)+current value

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] values = new int[10001];
        for (int num : nums)
            values[num] += num;

        int prev1 = 0;
        int prev2 = 0;

        for (int value : values) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + value, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
     */

    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] values = new int[10001];
        for (int num : nums)
            values[num] += num;

        int prev1 = 0;
        int prev2 = 0;

        for (int value : values) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + value, prev1);
            prev2 = tmp;
        }
        return prev1;

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();


        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        int res = deleteAndEarn(arr);
        System.out.println(res);

        scanner.close();
    }
}
