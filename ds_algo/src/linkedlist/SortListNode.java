package linkedlist;

import java.util.Arrays;
import java.util.List;

public class SortListNode {

    public static void main(String[] args) {
       ListNode head = NodeUtils.getListNodes(Arrays.asList(1,5,4,3,2));
       ListNode abc =sortList(head);
       NodeUtils.printList(abc);
    }

    public static ListNode sortList(ListNode head) {

        int count = NodeUtils.countNode(head);

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        for(int i=0 ; i < count ; i++){

            previous = null;
            current = head;
            next = head.next;

            while( next!= null){
                if( current.val > next.val){

                    if(previous==null){
                        head = next;
                    }
                    else{
                        previous.next = next;
                    }

                    current.next = next.next;
                    next.next = current;
                    previous = next;
                    next = current.next;


                }
                else{

                    previous = current;
                    current = next;
                    next = next.next;

                }



            }

        }
        return head;
    }



}
