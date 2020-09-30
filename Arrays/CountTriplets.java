import java.io.IOException;
import java.util.*;

public class CountTriplets {
    /*You are given an array and you need to find number of triplets of indices
    such that the elements at those indices are in geometric progression for a given common ratio r and i<j<k .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets
forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio.
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and .

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index , , , .*/

        static long countTriplets(List<Long> arr, long r) {
            if(arr.size() <3) {
                return 0;
            }
            /*Complexity: o(n^3)
            for(int i=0;i<arr.size();i++) {
                for(int j=i+1;j<arr.size();j++) {
                    for(int k=j+1;k<arr.size();k++) {
                        if(arr.get(k)/arr.get(j) == r && arr.get(j)/arr.get(i) == r) {
                            count++;
                        }
                    }
                }
            }*/
           /* Map<Long, Long> map = new HashMap<>();
            for(Long element: arr){
                if(map.containsKey(element)) {
                    Long value = map.get(element);
                    map.put(element,value+1);
                } else {
                    map.put(element, 1L);
                    System.out.println("New element added: " + element);
                }
            }
            for (Long aLong : map.keySet()) {
                if(map.containsKey(aLong*r)) {
                    if(map.containsKey(aLong*r*r)) {
                        Long a = map.get(aLong);
                        Long b = map.get(aLong*r);
                        Long c = map.get(aLong*r*r);
                        Long max = Math.max(a,Math.max(b,c));
                        count+=max;
                        System.out.println("At element" + aLong);
                        System.out.println(" Count: "+ count);
                    }
                }
            }*/

            long total = 0;
            Map<Long, Long> count = new HashMap<>(); // count of ints
            Map<Long, Long> tuplets = new HashMap<>(); // map 2nd -> count of links

            for (int i = 0; i < arr.size(); ++i) {
                //System.out.printf("i=%d\n", i);
                long val = arr.get(i);
                // inc total
                if (val % r == 0 && tuplets.containsKey(val / r)) {
                    total += tuplets.get(val / r);
                    //System.out.printf("%dx %d -> %d -> %d\n", t.count, t.first, val / r, val);
                }
                // create links/tuplets
                if (tuplets.containsKey(val)) {
                    tuplets.put(val, tuplets.get(val) + count.get(val/r));
                    //System.out.printf("%dx %d -> %d\n", tuplets.get(val).count, tuplets.get(val).first, val);
                } else if (val % r == 0 && count.containsKey(val / r)) {
                    //System.out.printf("%dx %d -> %d\n", count.get(val/r), val/r, val);
                    tuplets.put(val, count.get(val / r));
                }

                // inc count
                if (count.containsKey(val))
                    count.put(val, count.get(val)+1);
                else
                    count.put(val, 1L);
            }

            return total;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            System.out.println("Enter the size of the array: \n");
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Enter the array of size " + n + "\n");
            List<Long> arr = new ArrayList<>();

            //String[] arrItems = scanner.nextLine().split("\n");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextLong());
            }
            Long r;
            System.out.println("Enter the value r:  ");
            r = scanner.nextLong();


            Long res = countTriplets(arr, r);
            System.out.println(res);

            scanner.close();
        }

}
