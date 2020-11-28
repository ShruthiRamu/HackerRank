import java.io.IOException;
import java.util.*;

public class SubArraySum {
    public static class Key {
        String key;
        public Key(String key) {
            this.key=key;
        }
    }
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

    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

        if(remain < 0) return; /** no solution */
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i < cand.length; i++) {
                if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /*
    Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?



Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1

     */

    public int firstMissingPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = nums[start] - 1;
            if (index == start)
                start++;
            else if (index < 0 || index > end || nums[start] == nums[index])
                nums[start] = nums[end--];
            else {
                nums[start] = nums[index];
                nums[index] = index + 1;
            }
        }
        return start + 1;
    }

    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

     */

    public boolean canJump(int[] nums) {
        int n=nums.length;
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+nums[i]>=last)last=i;
        }
        return last<=0;
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
    /*Map<String, Integer> map = new HashMap<>();
    map.put("A",Integer.valueOf(1));
    map.put("A", Integer.valueOf(2));

    System.out.println(map.get("A"));

    Map<Key,Integer> map1= new HashMap<>();
    Key key1 = new Key("A");
    Key key2 = new Key("A");
    map1.put(key1, Integer.valueOf(1));
    map1.put(key2, Integer.valueOf(2));

        System.out.println(map1.get(key1));

        System.out.println("Without terminal");
        Arrays.stream(new int[]{1,2,3}).map(i-> {System.out.println("doubling" + i); return i*2;});

        System.out.println("With terminal");
        Arrays.stream(new int[]{1,2,3}).map(i-> {System.out.println("doubling" + i); return i*2;}).sum();*/

        scanner.close();
    }
}
