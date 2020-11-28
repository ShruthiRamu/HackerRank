import java.io.IOException;
import java.util.Scanner;

public class JumpGame {

    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
     */

    public static int jump(int[] nums) {
        /*int len = nums.length;
        int jumps = 0, curEnd = 0, curFarthest = 0;
	    for (int i = 0; i < len - 1; i++) {
		    curFarthest = Math.max(curFarthest, i + nums[i]);
		    if (i == curEnd) {
			    jumps++;
			    curEnd = curFarthest;
		    }
	    }
	    return jumps;*/

        // If nums.length < 2, means that we do not
        // need to move at all.
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // First set up current region, which is
        // from 0 to nums[0].
        int l = 0;
        int r = nums[0];
        // Since the length of nums is greater than
        // 1, we need at least 1 step.
        int step = 1;

        // We go through all elements in the region.
        while (l <= r) {

            // If the right of current region is greater
            // than nums.length - 1, that means we are done.
            if (r >= nums.length - 1) {
                return step;
            }

            // We should know how far can we reach in current
            // region.
            int max = Integer.MIN_VALUE;
            for (; l <= r; l++) {
                max = Math.max(max, l + nums[l]);
            }

            // If we can reach far more in this round, we update
            // the boundary of current region, and also add a step.
            if (max > r) {
                l = r;
                r = max;
                step++;
            }
        }

        // We can not finish the job.
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



        System.out.println(jump(arr));


        scanner.close();
    }
}
