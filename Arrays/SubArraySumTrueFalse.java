import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubArraySumTrueFalse {

    /*
    Given n positive integers elements in an array and a target, find if any consecutive sum of elements meet target.   Example: {1,6,8,10,22,3,44} Target: 35 return: true, target: 13 return false  Limitation;  Time complexity: O(n) Space complexity: O(1)
     */
    /*public static boolean subarraySum(int[] nums, int k) {
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
            if(map.containsKey(diff)) return true;
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return false;
    }*/

    public static boolean subarraySum(int[] nums, int k)
    {
        int curr_sum=nums[0],start=0;
        for(int i=1;i<=nums.length;i++) {
            if(curr_sum == k) return true;
            while(curr_sum>k && start<i-1) {
                curr_sum-=nums[start];
                start++;
            }
            if(i<nums.length) {
                curr_sum+=nums[i];
            }
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



        System.out.println(subarraySum(arr, target));


        scanner.close();
    }
}
