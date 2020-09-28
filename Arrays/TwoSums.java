import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSums {

    /*Given nums = [2, 7, 11, 15], target = 9.

    The output should be [0, 1].
    Because nums[0] + nums[1] = 2 + 7 = 9.*/

    public static int[] twoSum(int[] nums, int target) {
        /* Brute Force Approach: Complexity O(n^2)
        for(int i=0,j=1; i<nums.length && j<nums.length;i++,j++) {
            if(nums[i] + nums[j] == target) {
                indicies_array[0]=i;
                indicies_array[1]=j;
            }
        }*/

        //Efficient: Complexity O(n)
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
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



        int[] res = twoSum(arr, target);
        if(res.length == 2) {
            System.out.println(res[0]+" " + res[1]);
        } else {
            System.out.println("No solutions found");
        }

        scanner.close();
    }
}
