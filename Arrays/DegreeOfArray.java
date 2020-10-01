import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DegreeOfArray {
    /*
    Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.



Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
     */
    public static int findShortestSubArray(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num:nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }

        int degree=0;
        for(int value:frequencyMap.values()){
            degree=Math.max(value, degree);
        }

        if(degree==1 && n>0){
            return 1;
        }
        System.out.println(degree);

        int min= Integer.MAX_VALUE;
        int frequency=0;

        /*for(int i=n-1;i>=0;i--){
            frequency=getFrequency(nums,i);
            if(degree == frequency) {
                min = Math.min(min, i);
            }
        }*/

        Map<Integer, LinkedList<Integer>> table=new HashMap<>();
        for(int i=0;i<n;i++){
            if(frequencyMap.get(nums[i])==degree){
                LinkedList<Integer> list=table.computeIfAbsent(nums[i],k->new LinkedList<Integer>());
                list.add(i);
                table.put(nums[i],list);
            }
        }

        for(int i:table.keySet()){
            int a=table.get(i).getLast();
            int b=table.get(i).getFirst();
            min=Math.min(min,a-b+1);
        }
        return min;
    }
    /*
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        Map<Integer, Element> map = new HashMap<Integer, Element>();
        int maxFrequency = 0;
        int diff = 0;
        for (int i = 0; i < len; i++) {
            //Store the element in the map along with the start index when the num was first seen
            //and the last index when the num was last seen and its frequency
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).lastIdx = i;
                map.get(nums[i]).frequency++;
            } else {
                map.put(nums[i], new Element(i));
            }

            Element e = map.get(nums[i]);

            //if we are finding multiple elements with same high frequency
            //then we check..if the diff b/w the first and last index for the current element is smaller than the diff b/w the rest of the max frequency numbers
            if (e.frequency == maxFrequency && e.lastIdx - e.firstIdx < diff) {
                diff = e.lastIdx - e.firstIdx;
            }
            //else check if the element has the highest frequency..
            //if yes.. then update maxFrequency and diff
            else if (e.frequency > maxFrequency) {
                maxFrequency = e.frequency;
                diff = e.lastIdx - e.firstIdx;
            }
        }
        return diff + 1;
    }
}

class Element {
    int firstIdx = -1;
    int lastIdx = -1;
    int frequency = 0;

    public Element(int i) {
        firstIdx = i;
        lastIdx = i;
        frequency = 1;
    }
}
     */
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

        int res = findShortestSubArray(arr);
        System.out.println(res);

        scanner.close();
    }
}
