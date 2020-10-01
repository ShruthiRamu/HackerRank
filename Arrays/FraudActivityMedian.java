import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FraudActivityMedian {
/*
HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.

Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.

For example,  and . On the first three days, they just collect spending data. At day , we have trailing expenditures of . The median is  and the day's expenditure is . Because , there will be a notice. The next day, our trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the period, there was one notice sent.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)

Function Description

Complete the function activityNotifications in the editor below. It must return an integer representing the number of client notifications.

activityNotifications has the following parameter(s):

expenditure: an array of integers representing daily expenditures
d: an integer, the lookback days for median spending
Input Format

The first line contains two space-separated integers  and , the number of days of transaction data, and the number of trailing days' data used to calculate median spending.
The second line contains  space-separated non-negative integers where each integer  denotes .

Constraints

Output Format

Print an integer denoting the total number of times the client receives a notification over a period of  days.

Sample Input 0

9 5
2 3 4 2 3 6 8 4 5
Sample Output 0

2
Explanation 0

We must determine the total number of  the client receives over a period of  days. For the first five days, the customer receives no notifications because the bank has insufficient transaction data: .

On the sixth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the seventh day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the eighth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which does not trigger a notification because : .

On the ninth day, the bank has  days of prior transaction data, , and a transaction median of  dollars. The client spends  dollars, which does not trigger a notification because : .

Sample Input 1

5 4
1 2 3 4 4
Sample Output 1

0
There are  days of data required so the first day a notice might go out is day . Our trailing expenditures are  with a median of  The client spends  which is less than  so no notification is sent.
 */
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        /*O(n^2logn)int even=0;
        int median=0;
        int median_index;
        int[] trailArray= new int[d];
        int notice=0;
        if(d%2!=0) {
            even=0;
        } else {
            even=1;
        }
        for(int i=d;i<expenditure.length;i++){
            Arrays.sort(expenditure, i-d, i-1);
            if(even==0) {
                //means the median is at the d/2th index of the array
                median_index=d/2+i-d;
                median=expenditure[median_index];
            } else {
                median_index=((d/2+d/2+1)/2)+i-d;
                median=expenditure[median_index];
            }
            if(expenditure[i] >= (2*median)) {
                notice++;
            }

        }
        return notice;*/
        int[] count = new int[201];
        int result = 0;
        for(int i = 0; i < d; i++){
            count[expenditure[i]]++;
        }
        for(int i = d; i < expenditure.length; i++){
            int median = getMedian(count, d);
            if(median <= expenditure[i]){
                result++;
            }
            count[expenditure[i-d]]--;
            count[expenditure[i]]++;
        }
        return result;
    }
    public static int getMedian(int[] count, int d){
        int sum = 0;
        for(int i = 0; i < count.length; i++){
            sum += count[i];
            if((2*sum) == d){
                return (2*i+1);
            }else if((2*sum) > d){
                return (i*2);
            }
        }
        return 1;
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
        System.out.println("Enter the trailing days: ");
        target = scanner.nextInt();



        int  res = activityNotifications(arr, target);
        System.out.println(res);


        scanner.close();
    }
}
