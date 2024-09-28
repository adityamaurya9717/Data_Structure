package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeUtils {

    public static void main(String[] args) {

      ListNode l1    = getListNodes(Arrays.asList(1,4,7,9));
      ListNode l2   = getListNodes(Arrays.asList(2,3,5));
      printList(l1);
      printList(l2);
      ListNode node = mergeTwoLists(l1,l2);
      printList(node);

    }

    public static int countNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;

    }

    public static ListNode getListNodes(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4,5,6,7,8);
        List<Integer> nums2 = Arrays.asList(10, 20, 30, 40,50,60,70,80);
        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4,5,6,7,8);
        return getListNodes(nums);
    }
    public static ListNode getListNodes(List<Integer> nums){
        ListNode dummy = new ListNode(-1);
        ListNode previous = dummy;
        for (Integer num : nums) {
            ListNode temp = new ListNode(num);
            previous.next = temp;
            previous = temp;
        }
        return dummy.next;
    }


    public static void printList(ListNode head) {
        ListNode current = head;
        while (current!= null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * reverse a LinkedList
     *   1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
     *   to
     *   8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head){

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current!= null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * merge two LinkedList
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while( l1!=null && l2!=null ){

            if( l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }

        while (l1!=null){
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2!=null){
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * find middle of listNode by two pointer
     * @param l1
     * @return
     */
    public static ListNode middleNode(ListNode l1){

        ListNode slow = l1;
        ListNode fast = l1;

        while( fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Slow and Fast Pointer approach
     * @param l1
     * @return
     */
    public boolean hasCycle(ListNode l1){
        ListNode slow = l1;
        ListNode fast = l1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * SWAP PAIRS
     *  1->2->3->4->5->6
     *  2->1->4->3->6->5
     * @param l1
     */
    public void swapPairs(ListNode head){

        if(head==null || head.next==null){
            return;
        }
        ListNode current = head;
        ListNode temp = head.next;
        ListNode previous = null;

        while(current!=null && current.next!=null){

            ListNode next = current.next;

            current.next = next.next;

            next.next = current;
            if(previous!=null){
                previous.next = next;
            }
            previous = current;
            current = current.next;



        }

    }
}
