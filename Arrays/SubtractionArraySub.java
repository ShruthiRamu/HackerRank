import java.io.IOException;
import java.util.*;

public class SubtractionArraySub {
    /*
    Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
Output: Pair Found: (2, 80)

Input: arr[] = {90, 70, 20, 80, 50}, n = 45
Output: No Such Pair
     */
    static int arraySub(int[] arr, int r) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int key: map.keySet()){
            if((r>0 && map.containsKey(r+key)) || (r==0 && map.get(key)>1) ){
                count++;
            }
        }
        return count;
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
            arr[i]=scanner.nextInt();
        }
        int r;
        System.out.println("Enter the value r:  ");
        r = scanner.nextInt();


        int res = arraySub(arr, r);
        System.out.println(res);

        scanner.close();
    }

}
