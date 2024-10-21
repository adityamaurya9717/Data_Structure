package linkedlist;

import javax.xml.soap.Node;
import java.util.Arrays;

public class DeleteANode {

    public static void main(String[] args) {
       ListNode head = NodeUtils.getListNodes(Arrays.asList(1,1,2,3,4,5,6,7,8));
       NodeUtils.printList(head);
       ListNode newHead = delete(head,2);
        NodeUtils.printList(newHead);
        ListNode newHeadTwo = delete(head,3);
        NodeUtils.printList(newHeadTwo);
    }

    public static ListNode delete(ListNode node,int key) {

        ListNode newHead = node;
        ListNode curr = node;
        ListNode pre = null;
        while (curr != null) {
            if(curr.val == key){
                if(pre!=null) {
                    pre.next = curr.next;
                    curr=curr.next;
                }
                else{
                    ListNode temp = curr;
                    curr = curr.next;
                    temp.next = null;
                    newHead = curr;
                }
            }
            else{
                pre=curr;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
