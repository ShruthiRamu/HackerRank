import java.io.IOException;
import java.util.*;

public class LuckBalance {

    /*
    Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests.
     Initially, her luck balance is 0.She believes in "saving luck",
    and wants to check her theory. Each contest is described by two integers,  and :

     is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by ;
      if she loses it, her luck balance will increase by .
 denotes the contest's importance rating. It's equal to  if the contest is important, and it's equal to  if it's unimportant.
    If Lena loses no more than  important contests, what is the maximum amount of luck she can have after competing
    in all the preliminary contests? This value may be negative.

For example,  and:
    Contest		L[i]	T[i]
        1		5	    1
        2		1	    1
        3		4	    0

         If Lena loses all of the contests, her luck will be 5+1+4=10.
         Since she is allowed to lose k=2  important contests, and there are only 2  important contests.
         She can lose all three contests to maximize her luck at 10. If k=1 , she has to win at least 1  of the 2 important
         contests. She would choose to win the lowest value important contest worth 1  . Her final luck will be 5+4-1 = 8 .
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of contests: ");
        int n = scanner.nextInt();


        System.out.println("Enter the number of contests could be lost: ");
        int k = scanner.nextInt();

        int luck ;
        int imp ;

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int total=0;
        List<Integer> importantContests= new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the luck balance : ");
            luck=scanner.nextInt();
            System.out.println("Enter the importance rating: ");
            imp=scanner.nextInt();
            total+=luck;
            if(imp==1){
                importantContests.add(luck);
            }
        }

        Collections.sort(importantContests);
        int luckToFlip = 0;
        int mustWinImportantCount = importantContests.size() - k;
        for (int i=0; i<mustWinImportantCount; i++){
            luckToFlip += importantContests.get(i);
        }
        int result = total - 2*luckToFlip;
        System.out.println(result);


        scanner.close();
    }
}
