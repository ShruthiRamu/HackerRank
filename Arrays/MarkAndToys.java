import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int sum=0;
        int toys=0;
        for(int i=0;i<prices.length;i++){
            if(sum + prices[i]<=k) {
                sum+=prices[i];
                toys++;
            }
        }
        return toys;
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



        int  res = maximumToys(arr, target);
        System.out.println(res);


        scanner.close();
    }
}
