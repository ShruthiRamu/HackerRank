import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array. The Player class is provided in the editor below. It has two fields:

: a string.
: an integer.
Given an array of  Player objects, write a comparator that sorts them in order of decreasing score. If  or more players have the same score, sort those players alphabetically ascending by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.
In short, when sorting in ascending order, a comparator function returns -1 if a<b , 0 if a=b , and 1 if a>b .

For example, given  Player objects with  values of , we want to sort the list as .

Function Description

Declare a Checker class that implements the comparator method as described. It should sort first descending by score, then ascending by name. The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.

Input Format

Locked stub code in the Solution class handles the following input from stdin:

The first line contains an integer, , the number of players.
Each of the next  lines contains a player's respective  and , a string and an integer.

Constraints

Two or more players can have the same name.
Player names consist of lowercase English alphabetic letters.
Output Format

You are not responsible for printing any output to stdout. Locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.

Sample Input

5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
 */

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score>b.score) return -1;
        else if(a.score<b.score) return 1;
        else return a.name.compareTo(b.name);

    }
}
public class StringComparator {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            Player[] player = new Player[n];
            Checker checker = new Checker();

            for(int i = 0; i < n; i++){
                player[i] = new Player(scan.next(), scan.nextInt());
            }
            scan.close();

            Arrays.sort(player, checker);
            for(int i = 0; i < player.length; i++){
                System.out.printf("%s %s\n", player[i].name, player[i].score);
            }
        }

}
