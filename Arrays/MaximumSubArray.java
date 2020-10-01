import java.io.IOException;
import java.util.Scanner;

public class MaximumSubArray {
    public static int maxSum(int[] nums) {
        int maxSum=nums[0];
        int curr_sum=0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int num : nums) {
            curr_sum=Math.max(num+curr_sum, num);
            maxSum=Math.max(curr_sum, maxSum);
        }
        return maxSum;
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

        int res = maxSum(arr);
        System.out.println(res);

        scanner.close();
    }
}
