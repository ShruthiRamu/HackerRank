import javax.print.attribute.standard.PresentationDirection;
import java.io.IOException;
import java.util.*;

public class ThreeSum {

    /*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []*/

    public static ArrayList<List<Integer>> threeSum(int[] nums) {
        /* Brute Force Approach: Complexity O(n^3)
        for(int i=0,j=1,k=2; i<nums.length && j<nums.length && k.length<nums.length;i++,j++,k++) {
            if(nums[i] + nums[j] + nums[k] == 0) {
                indicies_array[0]=i;
                indicies_array[1]=j;
                indicies_array[2]=k;
            }
        }*/

        //Efficient: Complexity O(n^2)
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 3) return result;

        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] > nums[i - 1]) {
                int target = 0 - nums[i];
                int start = i + 1;
                int end = length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        ArrayList<Integer> elem = new ArrayList<Integer>();
                        elem.add(nums[i]);
                        elem.add(nums[start]);
                        elem.add(nums[end]);

                        result.add(elem);
                        start++;
                        end--;

                        // Remove duplicated results
                        while (start < end && nums[end + 1] == nums[end]) end--;
                        while (start < end && nums[start - 1] == nums[start]) start++;
                    } else if(nums[start] + nums[end] > target)
                    {
                        end--;
                    } else{
                        start++;
                    }
                }
            }
        }
        return result;
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

        ArrayList<List<Integer>> res = threeSum(arr);
        System.out.println(res);

        scanner.close();
    }
}
