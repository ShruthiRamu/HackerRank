import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxProduct {
    /*
    Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6


Example 2:

Input: [1,2,3,4]
Output: 24
     */

    public static int maximumProduct(int[] nums) {
        //BruteForce Approach O(n^3)
        /*int result= Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    result = Math.max(result, nums[i] * nums[j] * nums[k]);
                }
            }
        }
        return result;*/

            /* another approach
            int n=nums.length;
            Arrays.sort(nums);
            int max= Integer.MIN_VALUE;

           for(int i=0;i<n-2;i++) {
               if(nums[i] * nums[i+1] > 0){
                   max= Math.max(max, nums[i] * nums[i+1]);
               }
           }
           return max * nums[n-1];*/
        /*Another approach
        Arrays.sort(nums);
        int m=nums.length-1;
        return Math.max(nums[0]*nums[1]*nums[m],nums[m]*nums[m-1]*nums[m-2]);*/

        if(nums.length==3)
        {
            return nums[0]*nums[1]*nums[2];
        }
        int max1 = Integer.MIN_VALUE,
                max2 = Integer.MIN_VALUE,
                max3 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
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


        int res = maximumProduct(arr);
        System.out.println(res);

        scanner.close();
    }
}
