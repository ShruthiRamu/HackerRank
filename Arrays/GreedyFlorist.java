import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
    /*
    A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers
    and the money he makes. To do this, he decides he'll multiply the price of each flower by the number of that
    customer's previously purchased flowers plus 1. The first flower will be original price, 0+1 * original price ,
    the next will be 1+1 * original price  and so on.

Given the size of the group of friends, the number of flowers they want to purchase and the original
prices of the flowers, determine the minimum cost to purchase all of the flowers.

For example, if there are k=3 friends that want to buy n=4 flowers that cost c=[1 2 3 4] each will buy one of the
flowers priced [2 3 4]at the original price. Having each purchased x=1 flower, the first flower in the list, ,
will now cost 1+1 * 1=2.
The total cost will be 2+3+4+2=11.

Function Description

Complete the getMinimumCost function in the editor below. It should return the minimum cost to purchase all of the
flowers.

getMinimumCost has the following parameter(s):

c: an array of integers representing the original price of each flower
k: an integer, the number of friends
Input Format

The first line contains two space-separated integers  and , the number of flowers and the number of friends.
The second line contains  space-separated positive integers , the original price of each flower.

Constraints

Output Format

Print the minimum cost to buy all  flowers.

Sample Input 0

3 3
2 5 6
Sample Output 0

13
Explanation 0

There are  flowers with costs  and  people in the group. If each person buys one flower,
the total cost of prices paid is 2+5+6=13 dollars. Thus, we print 13  as our answer.

Sample Input 1

3 2
2 5 6
Sample Output 1

15
Explanation 1

There are 3 flowers with costs [2 5 6] and 2 people in the group. We can minimize the total purchase cost like so:

The first person purchases 2 flowers in order of decreasing price; this means they buy the more expensive flower (c1=5)
first at price  dollars and the less expensive flower () second at price  dollars.
The second person buys the most expensive flower at price  dollars.
We then print the sum of these purchases, which is 5+6+ ((1+1)*2), as our answer.

Sample Input 2

5 3
1 3 5 7 9
Sample Output 2

29
Explanation 2

The friends buy flowers for ,  and ,  and  for a cost of 9+7+5+(1+1)*3 + (1+1)*1 = 29 .
     */

    static int getMinimumCost(int k, int[] c) {
        int n=c.length;
        int sum=0;
        int previousPurchase=0;
        int tempCount=0;

        Arrays.sort(c);
        if(k>=n){ ///if number of friends are equal to or greater than number of flowers
            for(int i=0;i<n;i++){
                sum+=c[i];
            }
        } else{//if number of friends less than flowers
            for(int i=n-1;i>=0;i--) {
                if(tempCount == k) {
                    tempCount=0;
                    previousPurchase++;
                }
                sum+=(previousPurchase+1)*c[i];
                tempCount++;
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of flowers: ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the number of friends: ");
        int k=scanner.nextInt();

        System.out.println("Enter the cost of flowers " + n + "\n");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(getMinimumCost(k,arr));

        scanner.close();
    }
}
