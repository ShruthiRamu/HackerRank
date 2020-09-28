import java.io.IOException;
import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int nBribes = 0;
        /*for(int i=0;i<q.length;i++) {
            if(q[i] - i >= 4) {
                System.out.println("Too chaotic");
                return;
            } else {
                if((q[i] - i)==2  || (q[i] - i) ==-3) {
                    nBribes++;
                } else if(q[i] - i==3) {
                    nBribes+=2;
                }
            }
        }*/

        for(int i=q.length-1;i>=0;i--) {
            if(q[i] != i+1) {
                if(q[i-1] == i+1 && (i-1)>=0) {
                    nBribes++;
                    swap(q,i, i-1);
                } else if(q[i-2] == i+1 && (i-2)>=0) {
                    nBribes+=2;
                    swap(q,i-2,i-1);
                    swap(q,i-1,i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }


        System.out.println("Number bribes: " + nBribes);

    }
    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of test cases: \n");
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=0;i<t;i++) {
            System.out.println("Enter the size of the queue for the test case: " + i);
            int n = scanner.nextInt();
            int[] q = new int[n];

            //String[] arrItems = scanner.nextLine().split("\n");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("Enter the final state queue elements: ");
            for (int j = 0; j < n; j++) {
                q[j] = scanner.nextInt();
            }
            minimumBribes(q);
        }

        scanner.close();
    }
}
/*
It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue.
Initial positions increment by  from  at the front of the line to  at the back.

Any person in the queue can bribe the person directly in front of them to swap positions.
If two people swap positions, they still wear the same sticker denoting their original places in line.
One person can bribe at most two others. For example, if  and  bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place
to get the queue into its current state!

Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum
number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

q: an array of integers
Input Format

The first line contains an integer , the number of test cases.

Each of the next  pairs of lines are as follows:
- The first line contains an integer , the number of people in the queue
- The second line has  space-separated integers describing the final state of the queue.

Constraints

Subtasks

For  score
For  score

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state.
Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.

Sample Input

2
5
2 1 5 3 4
5
2 5 1 3 4
Sample Output

3
Too chaotic
Explanation

Test Case 1

The initial state:

pic1(1).png

After person 5 moves one position ahead by bribing person : 4

pic2.png

Now person 5 moves another position ahead by bribing person : 3

pic3.png

And person 2 moves one position ahead by bribing person : 1

pic5.png

So the final state is 2 1 5 3 4 after three bribing operations.

Test Case 2

No person can bribe more than two people, so its not possible to achieve the input state.
 */
