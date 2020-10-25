import java.io.IOException;
import java.util.Scanner;

public class FizzBuzz {

    /*
        Enter the number:
15
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
     */

    public static void fizzBuzz(int n) {
        // Write your code here

        for(int i=1;i<=n;i++){
            if(i%3 == 0 && i%5==0) {
                System.out.println("FizzBuzz");
            }
            else if(i%3==0 && i%5!=0){
                System.out.println("Fizz");
            }
            else if(i%5==0 && i%3!=0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int target;
        System.out.println("Enter the number: ");
        target = scanner.nextInt();

        fizzBuzz(target);

        scanner.close();
    }


}
