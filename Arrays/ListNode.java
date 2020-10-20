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

            scanner.close();
      }
}
