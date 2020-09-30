import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContinuousSubArray {
    /*
    Given a list of non-negative numbers and a target integer k,
    write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k,
     that is, sums up to n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     */
    public static boolean subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;

        for(int i = 0; i < nums.length ; i++){
            sum  += nums[i];
            if(k != 0) sum = sum % k;
            if( map.containsKey(sum) && i - map.get(sum) > 1) return true;
            if( !map.containsKey(sum) ) map.put(sum,i);
        }
        return false;

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



        boolean res = subarraySum(arr, target);
        System.out.println(res);


        scanner.close();
    }
}
