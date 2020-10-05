import javax.lang.model.element.Element;
import java.io.IOException;
import java.util.*;

public class LongestConsecutive {
    /*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

     */
    public static int longestConsecutive(int[] nums) {
        /*if(nums != null && nums.length > 0){
            Set<Integer> numSet = new HashSet();
            for(int num : nums)
                numSet.add(num);
            int answer = 1;
            for(int num : nums){
                if(!numSet.contains(num-1)){
                    int curr = 0;
                    while(numSet.contains(num++))
                        curr++;
                    answer = Math.max(answer,curr);
                }
            }
            return answer;
        }
        return 0;*/
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = Integer.MIN_VALUE;

        for(int num : nums)
        {
            if(!map.containsKey(num))
            {
                int left = 0;
                int right = 0;

                if(map.containsKey(num-1))
                {
                    left = map.get(num-1);
                }

                if(map.containsKey(num+1))
                {
                    right = map.get(num+1);
                }

                int currConsecutiveBoundary = left + right + 1;
                map.put(num-left ,  currConsecutiveBoundary);
                map.put(num+right , currConsecutiveBoundary);
                map.put(num,currConsecutiveBoundary );

                ans = Math.max(ans, left+right+1);
            }
        }

        return ans > Integer.MIN_VALUE ? ans: 0;

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

        int res = longestConsecutive(arr);
        System.out.println(res);

        scanner.close();
    }
}
