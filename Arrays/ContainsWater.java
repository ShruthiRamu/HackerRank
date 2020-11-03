import java.io.IOException;
import java.util.Scanner;

public class ContainsWater {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
    Find two lines, which, together with the x-axis forms a container, such that the container
    contains the most water.

    Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2


AKA, the general idea to find some max is to go through all cases where max value can possibly occur
and keep updating the max value. The efficiency of the scan depends on the size of cases you plan to scan.
To increase efficiency, all we need to do is to find a smart way of scan to cut off the useless cases
and meanwhile 100% guarantee the max value can be reached through the rest of cases.

In this problem, the smart scan way is to set two pointers initialized at both ends of the array.

Every time move the smaller value pointer to inner array. Then after the two pointers meet,
all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan.
Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation.
We need to prove that a10 can be reached by left pointer and during the time left pointer
stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove:
 when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer
at a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less
than area of a10 and a21. Because the area of a10 and a21 is at least height[a10] * (21-10) while the
area of a10 and a20 is at most height[a10] * (20-10). So there is a contradiction of assumption a10 and a20
has the max area. So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases
must be reached.
     */

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
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

        int res = maxArea(arr);
        System.out.println(res);

        scanner.close();
    }
}
