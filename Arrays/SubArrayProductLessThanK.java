import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubArrayProductLessThanK {
    /*
    Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        /*int n=nums.length;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(num<k){
                count++;
            }
        }
        for (int i=0;i<n; i++) {
            int product=nums[i];
            for(int j=i+1;j<n;j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                }
            }
        }
        return count;*/

        if(k<=1){
            return 0;
        }
        int prod=1;
        int left=0;
        int right=0;
        int res=0;
        while(right<nums.length){
            prod*=nums[right];
            while(prod>=k){
                prod/=nums[left];
                left++;
            }
            res+=right-left+1;
            right++;
        }
        return res;

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
        System.out.println("Enter the target product ");
        target = scanner.nextInt();



        int res = numSubarrayProductLessThanK(arr, target);
        System.out.println(res);

        scanner.close();
    }
}
