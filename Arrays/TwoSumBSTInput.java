import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSumBSTInput {
    /*
    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in
    the BST such that their sum is equal to the given target.

    Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true
     */
    TreeNode treeNode;
    public static  boolean findTarget(TreeNode root, int k) {
        boolean res = false;
        if (root != null) {
            List<Integer> inOrder = new ArrayList<>();
            getInOrder(root, inOrder);

            int s = 0, e = inOrder.size()-1;
            while (s<e) {
                int currSum = inOrder.get(s) + inOrder.get(e);
                if (currSum == k) {
                    res = true;
                    break;
                } else if (currSum > k) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return res;
    }
    public static void getInOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;
        getInOrder(root.left, inOrder);
        inOrder.add(root.val);
        getInOrder(root.right, inOrder);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        TreeNode root = new TreeNode();
        root = root.insert(root, 5);
        root.insert(root, 3);
        root.insert(root, 6);
        root.insert(root, 2);
        root.insert(root, 4);
        root.insert(root, 7);

        System.out.println(findTarget(root, 28));
    }
}
