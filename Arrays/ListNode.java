import java.io.IOException;
import java.util.Scanner;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
Accepted
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode dumHead = head;
            int carry = 0;
            while(l1 != null || l2 != null) {
                  int val1 = l1 == null ? 0 : l1.val;
                  int val2 = l2 == null ? 0 : l2.val;

                  int sum = val1 + val2 + carry;
                  carry = sum / 10;
                  sum = sum % 10;

                  dumHead.next = new ListNode(sum);
                  dumHead = dumHead.next;

                  if (l1 != null) l1 = l1.next;
                  if (l2 != null) l2 = l2.next;
            }
            if (carry > 0) {
                  dumHead.next = new ListNode(carry);
            }
            return head.next;
      }

      public static ListNode insertFront(int data, ListNode head) {
            ListNode newNode = new ListNode();
            newNode.val=data;
            newNode.next=null;

            if(head==null){
                  head = newNode;
                  return head;
            }

            newNode.next=head;
            head = newNode;
            return head;
      }

      public static ListNode insertPosition(int data, int pos, ListNode head) {
            ListNode newNode = new ListNode();
            newNode.val=data;
            newNode.next=null;

            if(head==null){
                  head = newNode;
                  return head;
            }
            if(pos == 1) {
                  newNode.next=head;
                  head = newNode;
                  return head;
            }

            int count=1;
            ListNode prev,curr;
            curr=head;
            prev=head;

            while(count < pos && curr!=null){
                  prev=curr;
                  curr=curr.next;
                  count++;
            }
            prev.next=newNode;
            newNode.next=curr;

            return head;
      }

      public static ListNode deleteFront(ListNode head) {

            if(head==null){
                  return null;
            }
            head = head.next;
            return head;
      }

      public static ListNode insertEnd(int data, ListNode head) {
            ListNode newNode = new ListNode();
            newNode.val=data;
            newNode.next=null;

            if(head==null){
                  head = newNode;
                  return head;
            }
            ListNode prev,curr;
            prev=head;
            curr=head;
            while(curr!=null){
                  prev=curr;
                  curr=curr.next;
            }
            newNode.next=curr;
            prev.next=newNode;
            return head;
      }

      public static ListNode deleteEnd(ListNode head) {
            if(head==null || head.next==null){
                  return null;
            }
            ListNode curr,prev;
            curr = head;
            prev=head;
            while(curr.next!=null) {
                  prev=curr;
                  curr=curr.next;
            }
            prev.next=null;
            return head;
      }

      public static ListNode deletePosition(int pos, ListNode head) {


            if(head==null){
                  return head;
            }
            if(pos == 1) {
                  head = head.next;
                  return head;
            }

            int count=1;
            ListNode prev,curr;
            curr=head;
            prev=head;

            while(count < pos && curr!=null){
                  prev=curr;
                  curr=curr.next;
                  count++;
            }
           if(curr==null){
                  System.out.println("Position not allowed");
                  return head;
            }
            prev.next=curr.next;
            return head;
      }

      public static ListNode findNthNodeFromEnd(ListNode head, int n) {
            ListNode pNthNode = null, pTemp=head;
            for(int i=0;i<n;i++) {
                  if(pTemp!=null) {
                        pTemp=pTemp.next;
                  }
            }

            while(pTemp!=null) {
                  if(pNthNode==null) {
                        pNthNode=head;
                  } else {
                        pNthNode=pNthNode.next;
                  }
                  pTemp=pTemp.next;
            }
            if(pNthNode!=null)
                  return pNthNode;
            return null;
      }

      public int isLoop(ListNode head){
            ListNode slow=head, fast=head;
            while(fast!=null && slow!=null && fast.next!=null) {
                  slow=slow.next;
                  fast=fast.next.next;
                  if(fast==slow) return 1;
            }
            return 0;
      }
      public ListNode ifLoopReturnStart(ListNode head){
            ListNode slow=head, fast=head;
            int isLoop=0;
            while(fast!=null && slow!=null && fast.next!=null) {
                  slow=slow.next;
                  fast=fast.next.next;
                  if(fast==slow){
                        isLoop=1;
                        break;
                  }
            }
            if(isLoop==1){
                  slow=head;
                  while(slow!=fast) {
                        slow=slow.next;
                        fast=fast.next;
                  }
                  return slow;
            }

            return null;
      }

      public int ifLoopReturnLength(ListNode head){
            ListNode slow=head, fast=head;
            int isLoop=0;
            int count=0;
            while(fast!=null && slow!=null && fast.next!=null) {
                  slow=slow.next;
                  fast=fast.next.next;
                  if(fast==slow){
                        isLoop=1;
                        break;
                  }
            }
            if(isLoop==1){
                fast=fast.next;
                while(fast!=slow){
                      count++;
                      fast=fast.next;
                }
            }

            return count;
      }

      public static void traverseList(ListNode head){
            if(head == null) {
                  System.out.println("Empty list");
                  return;
            }

            ListNode curr=head;
            while(curr!=null) {
                  System.out.println(curr.val);
                  curr=curr.next;
            }
      }

      public static int length(ListNode head){
            if(head == null) {
                  System.out.println("Empty list");
                  return 0;
            }

            ListNode curr=head;
            int count=0;
            while(curr!=null) {
                  count++;
                  curr=curr.next;
            }
            return count;
      }

      public static ListNode insertSorted(ListNode head, int data) {
            ListNode prev=head, curr=head;
            ListNode newNode = new ListNode();
            newNode.val=data;
            newNode.next=null;
            if(head==null) {
                  return newNode;
            }

            while(curr!=null && curr.val < newNode.val){
                  prev=curr;
                  curr=curr.next;
            }

            prev.next=newNode;
            newNode.next=curr;
            return head;
      }

      public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode returnNode = new ListNode(-1);
            ListNode headNode = returnNode;
            while (l1 != null && l2 != null) {
                  if (l1.val <= l2.val) {
                        returnNode.next = l1;
                        l1 = l1.next;
                  } else {
                        returnNode.next = l2;
                        l2 = l2.next;
                  }
                  returnNode = returnNode.next;
            }
            if (l1 == null) {
                  returnNode.next = l2;
            } else if (l2 == null) {
                  returnNode.next = l1;
            }
            return headNode.next;
      }

      /*
      You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
       */
      public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            int len = lists.length;                 //no extra memory, decrease end of lists each time when merge two
            while(len != 1){
                  for(int i = 0;i<len/2;i++){
                        lists[i] = mergeTwo(lists[i*2],lists[i*2+1]);
                  }
                  if(len % 2 == 1){                   //move the last one
                        lists[len/2] = lists[len-1];
                  }
                  len = (len+1)/2;                    //decrease to half
            }
            return lists[0];
      }

      private ListNode mergeTwo(ListNode node1, ListNode node2){
            if(node1 == null) return node2;
            if(node2 == null) return node1;
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            while(node1 != null || node2 != null){
                  if(node2 == null || node1 != null && node1.val < node2.val){
                        curr.next = node1;
                        node1 = node1.next;
                  }else{
                        curr.next = node2;
                        node2 = node2.next;
                  }
                  curr = curr.next;
            }
            return dummy.next;
      }
      /*
      Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]

       */
      /**

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

      public class Codec {
            private static final String spliter = ",";
            private static final String NN = "X";

            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                  StringBuilder sb = new StringBuilder();
                  buildString(root, sb);
                  return sb.toString();
            }

            private void buildString(TreeNode node, StringBuilder sb) {
                  if (node == null) {
                        sb.append(NN).append(spliter);
                  } else {
                        sb.append(node.val).append(spliter);
                        buildString(node.left, sb);
                        buildString(node.right,sb);
                  }
            }
            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                  Deque<String> nodes = new LinkedList<>();
                  nodes.addAll(Arrays.asList(data.split(spliter)));
                  return buildTree(nodes);
            }

            private TreeNode buildTree(Deque<String> nodes) {
                  String val = nodes.remove();
                  if (val.equals(NN)) return null;
                  else {
                        TreeNode node = new TreeNode(Integer.valueOf(val));
                        node.left = buildTree(nodes);
                        node.right = buildTree(nodes);
                        return node;
                  }
            }
      }
*/
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


      public ListNode rotateRight(ListNode head, int n) {
            /*
            Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
             */
            if (head==null||head.next==null) return head;
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode fast=dummy,slow=dummy;

            int i;
            for (i=0;fast.next!=null;i++)//Get the total length
                  fast=fast.next;

            for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
                  slow=slow.next;

            fast.next=dummy.next; //Do the rotation
            dummy.next=slow.next;
            slow.next=null;

            return dummy.next;
      }
      private static final Scanner scanner = new Scanner(System.in);

      public static void main(String[] args) throws IOException {

            System.out.println("Enter the size of the array: \n");
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Enter the array of size " + n + "\n");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                  //arr[i] = scanner.nextInt();
            }

            System.out.println(addTwoNumbers(null,null));

            ListNode head = insertEnd(1,null);
            head = insertEnd(2,head);
            head = insertEnd(3,head);
            head = insertEnd(4,head);
            head = insertFront(5,head);


            traverseList(head);
            System.out.println("Length of list: " + length(head));

            head = deleteFront(head);
            traverseList(head);
            System.out.println("Length of list: " + length(head));


            head = deleteEnd(head);
            traverseList(head);
            System.out.println("Length of list: " + length(head));

            head=insertPosition(10, 4, head);
            traverseList(head);
            System.out.println("Length of list: " + length(head));

            head=deletePosition(2, head);
            traverseList(head);
            System.out.println("Length of list: " + length(head));

            ListNode nthNode=findNthNodeFromEnd(head, 1);
            System.out.println(nthNode.val);

            System.out.println("Creating linked list sorted: ");
            ListNode head1 = insertSorted(null,7);
            head1 = insertSorted(head1,2);
            head1 = insertSorted(head1,1);
            head1 = insertSorted(head1,3);
            head1 = insertSorted(head1,4);
            traverseList(head1);

            scanner.close();
      }
}
