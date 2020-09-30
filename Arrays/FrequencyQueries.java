import java.io.IOException;
import java.util.*;

public class FrequencyQueries {

    /*
    You are given  queries. Each query is of the form two integers described below:
-1 x  : Insert x in your data structure.
- 2 y : Delete one occurence of y from your data structure, if present.
- 3 z : Check if any integer is present whose frequency is exactly z. If yes, print 1 else 0.

The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: .

Function Description

Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

freqQuery has the following parameter(s):

queries: a 2-d array of integers
Input Format

The first line contains of an integer , the number of queries.
Each of the next  lines contains two integers denoting the 2-d array .

Constraints

All
Output Format

Return an integer array consisting of all the outputs of queries of type .

Sample Input 0

8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0

0
1
Explanation 0

For the first query of type , there is no integer whose frequency is  (). So answer is .
For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

Sample Input 1

4
3 4
2 1003
1 16
3 1
Sample Output 1

0
1
Explanation 1

For the first query of type , there is no integer of frequency . The answer is .
 For the second query of type , there is one integer,  of frequency  so the answer is .

Sample Input 2

10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2

0
1
1
Explanation 2

When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.
     */

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        List<Integer> array = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] quantities = new int[queries.length + 1];
        int frequency, value;

        for(int[] element: queries) {
            value = element[1];
            switch (element[0]){
                case 1:

                    /*if(map.containsKey(element[1])) {
                        map.put(element[1], map.get(element[1]) + 1);
                    } else {
                        map.put(element[1], 1);
                    }*/
                    frequency = map.getOrDefault(value, 0);
                    map.put(value, frequency + 1);
                    quantities[frequency]--;
                    quantities[frequency + 1]++;

                    break;
                case 2:
                   /* if(map.containsKey(element[1])) {
                        if(map.get(element[1]) <=1 ) {
                            map.remove(element[1]);
                        }
                        else {
                            map.put(element[1], map.get(element[1]) - 1);
                        }
                    }*/
                    frequency = map.getOrDefault(value, 0);
                    if (frequency == 0) break;
                    if (frequency == 1) map.remove(value);
                    else map.put(value, frequency - 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency - 1]++;
                    break;
                case 3:
                    /*if(map.containsValue(element[1])) {
                        array.add(1);
                    } else {
                        array.add(0);
                    }*/
                    if (value >= quantities.length) array.add(0);
                    else array.add(quantities[value] > 0 ? 1 : 0);
                    break;
                default:
                    System.out.println("Invalid operation entered. Valid operations are 1,2 and 3");
            }
        }
        return array;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of queries: ");
        int m = scanner.nextInt();

        int[][] queries = new int[m][2];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the " + (i+1) + "th query (in the form operation, data element)");
            int[] query = new int[2];
            for(int j=0;j<2;j++) {
                query[j]= scanner.nextInt();
            }
            queries[i]=query;
        }

        List<Integer> result = freqQuery(queries);

        System.out.println(result);


        scanner.close();
    }
}
