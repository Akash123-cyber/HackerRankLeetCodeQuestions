package HackerRankLeetCodeQuestions;

public class LeetCode2095DeletetheMiddleNodeofLinkedList {

    static class ListNode{

        int value;
        ListNode next;

        ListNode(int value){
            this.value = value;
            this.next = null;
        }

    }


    static ListNode deleteMiddle(ListNode head) {

        //if head is single node in the list
        if(head == null || head.next == null) return null;

        //to delete the middle node we will use the slow and fast pointer 
        // approach slightly differ from the traditional one where we used
        // to run both slow and fast pointer at their respective speeds fast is 2x of slow
        // when fast was used to reach the null slow reached the middle point of the Linked List
        // But now we need to delete that same node for that we need to travel to just a node before the middle node 
        
        // for this we will create a starting gap of 1 one node between slow and fast
        // to achieve this we will initialize fast = head.next.next and then it will iterate until it reaches null
        //  list: 1->2->3->4->null slow = 1; fast = 3 a gap of one node
        // but this time fast got a head start of one node more than slow so it will reach the null or last node faster
        // and slow will reach just a node before middle node


        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    static void printList(ListNode head){

        ListNode temp = head;

        System.out.println("List: ");
        while(temp!=null){

            System.out.print(temp.value+" --> ");
            temp =temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        // head.next.next.next.next = new ListNode(50);

        printList(head);

        head = deleteMiddle(head);

        printList(head);
    }
    
}
