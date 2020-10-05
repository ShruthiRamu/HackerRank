import java.io.IOException;
import java.util.Scanner;

public class Factorial {

    public static int fact(int n){
        if(n==1) return 1;
        if(n==0) return 1;
        else return (n * fact(n-1));
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        System.out.println("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.println(n+"!="+fact(n));

    }
}
