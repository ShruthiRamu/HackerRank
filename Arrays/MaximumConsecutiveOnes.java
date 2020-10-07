import java.io.IOException;
import java.util.Scanner;

public class MaximumConsecutiveOnes {
    /*
    Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
     */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max=0;
        int count=0;


        for(int i=0;i<n;i++){
            if(nums[i]==1)
                count++;
            else if(nums[i]==0)
                count=0;
            max=Math.max(max,count);
        }
        return max;

    }

    /*
    Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.


Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1
Accepted
68,887
Submissions
115,424
Seen this question in a real interview before?

Yes

No
One thing's for sure, we will only flip a zero if it extends an existing window of 1s. Otherwise, there's no point in doing it, right? Think Sliding Window!
Since we know this problem can be solved using the sliding window construct, we might as well focus in that direction for hints. Basically, in a given window, we can never have > K zeros, right?
We don't have a fixed size window in this case. The window size can grow and shrink depending upon the number of zeros we have (we don't actually have to flip the zeros here!).
The way to shrink or expand a window would be based on the number of zeros that can still be flipped and so on.
     */
    public static int findMaxConsecutiveOnesKFlips(int[] A, int K) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            if (A[windowEnd] == 1)
                maxOnesCount++;

            if(windowEnd - windowStart + 1 - maxOnesCount > K) {
                if (A[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;

        /*
        int left = 0, right = 0, allowed = K, max = 0;
        while (right < A.length) {
            if (A[right] == 1 || A[right] == 0 && allowed > 0) {
                if (A[right] == 0) allowed--;
                right++;
            } else {
                max = Math.max(right - left, max);
                if (A[left] == 0) allowed++;
                left++;
            }
        }
        max = Math.max(right - left, max);
        return max;
         */

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


        int res = findMaxConsecutiveOnes(arr);
        System.out.println(res);

        scanner.close();
    }
}
