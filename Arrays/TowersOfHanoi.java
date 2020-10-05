import java.io.IOException;
import java.util.Scanner;

public class TowersOfHanoi {

    public static void towersOfHanoi(int n, char a, char b, char temp){
        if(n==1) {
            System.out.println("Move disk 1 from "+a +" to "+ b);
            return;
        }
        towersOfHanoi(n-1,a,temp,b);
        System.out.println("Move disk "+n+" from "+a +" to "+ b);
        towersOfHanoi(n-1,temp,b,a);

    }
    public static final Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        System.out.println("Enter the number of disks: ");
        int n = scanner.nextInt();
        towersOfHanoi(n, 'A', 'B','T');
    }
}
