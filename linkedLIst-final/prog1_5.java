//import java.util.*;
///*
//* 1. Reverse the linked list
//* 2. Detect cycle
//* 3. Merge Linked List
//* 4. Delete Without Head node
//* 5. Remove duplicate from unsorted linked list
//* */
//
//public class prog1_5 {
//    static class Node{
//        int data;
//        Node next;
//        Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    //function to insert
//    public static Node insert(Node head, int data){
//        if(head == null) return new Node(data);
//        Node end = head;
//        while(end.next != null) end = end.next;
//        end.next = new Node(data);
//        return head;
//    }
//    //function to display
//    public static void display(Node head){
//        Node temp = head;
//        while(temp != null){
//            System.out.print(temp.data + "->");
//            temp = temp.next;
//        }
//        System.out.println("NULL");
//    }
//    //reversing the linked list
//    public static Node reverse(Node head){
//        Node dummy = null;
//        while(head != null){
//            Node next = head.next;
//            head.next = dummy;
//            dummy = head;
//            head = next;
//        }
//        return dummy;
//    }
//
//    //detecting cycle
//    public static boolean detectCycle(Node head){
//        Node slow = head;
//        Node fast = head;
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast) return true;
//        }
//        return false;
//    }
//
//    public static void createCycle(Node head, int len){
//        Node temp = head;
//        while(len != 0){
//            temp = temp.next;
//            len--;
//        }
//        temp.next = head;
//    }
//
//    //merging 2 linked list
//    public static Node merge(Node head1, Node head2){
//        if(head1 == null) return head2;
//        if(head2 == null) return head1;
//        Node result = null;
//        if(head1.data < head2.data){
//            result = head1;
//            result.next = merge(head1.next, head2);
//        }
//        else{
//            result = head2;
//            result.next = merge(head1, head2.next);
//        }
//        return result;
//    }
//
//    //deleting the node without the head
//    public static void deleteNode(Node del){
//        if(del == null || del.next == null) return;
//        Node temp = del.next;
//        del.data = del.next.data;
//        del.next = del.next.next;
//        temp.next = null;
//    }
//
//    //remove the duplicate from the unsorted array
//    public static void removeDuplicate(Node head){
//        HashSet<Integer> hs = new HashSet<>();
//        Node curr = head;
//        Node prev = head;
//        while(curr != null){
//            int val = curr.data;
//            if(hs.contains(val)){
//                prev.next = prev.next.next;
//            }
//            else{
//                hs.add(val);
//            }
//            prev = curr;
//            curr = curr.next;
//        }
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] values1 = sc.nextLine().split(" ");
//
//        String[] values2 = sc.nextLine().split(" ");
//        Node head1 = null;
//        Node head2 = null;
//        for(int i = 0 ; i < values1.length ; i++){
//            head1 = insert(head1, Integer.parseInt(values1[i]));
//        }
//        for(int i = 0 ; i < values2.length ; i++){
//            head2 = insert(head2, Integer.parseInt(values2[i]));
//        }
//        display(head1);
//        display(head2);
//        Node result = merge(head1, head2);
//        display(result);
//        deleteNode(result.next.next.next.next);
//        display(result);
//        removeDuplicate(result);
//        display(result);
//    }
//}
