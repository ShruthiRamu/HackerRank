import java.io.IOException;
import java.util.*;

public class SubArraySum {
    /*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays
    whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2


Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    public static int subarraySum(int[] nums, int k) {
        int count=0;
        Map<Integer, Integer> map = new HashMap<>(){
            {
                put(0,1);
            }
        };

        int sum=0;
        for(int element: nums) {
            sum += element;
            int diff = sum-k;
            if(map.containsKey(diff)) count+=map.get(diff);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
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



        int res = subarraySum(arr, target);
        System.out.println(res);


        scanner.close();
    }
}
