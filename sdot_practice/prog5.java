///*
//Example 2:
//Input:
//Linked list: 1→2→3→4→5→6→7
//k: 2
//Output:
//Result: 2→1→4→3→6→5→7
//* */
//
//import java.util.*;
//
//public class prog5 {
//    static class Node{
//        int data;
//        Node next;
//        public Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    public static Node insert(Node head, int data){
//        if(head == null) return new Node(data);
//        Node end = head;
//        while(end.next != null) end = end.next;
//        end.next = new Node(data);
//        return head;
//    }
//    public static void display(Node head){
//        Node temp = head;
//        while(temp != null){
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//    public static int len(Node head){
//        if(head == null) return 0;
//        return 1 + len(head.next);
//    }
//    public static Node reverse(Node head, int k){
//        Node dummy = new Node(-1);
//        Node last_tail = dummy;
//        int num = len(head);
//        Node curr = head;
//        Node prev = null;
//        while(num >= k){
//            Node tail = curr;
//            for(int i = 0 ; i < k ; i++){
//                Node next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            last_tail.next = prev;
//            last_tail = tail;
//            num -= k;
//        }
//        last_tail.next = curr;
//        return dummy.next;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] values = sc.nextLine().split(" ");
//        int k = sc.nextInt();
//        Node head = null;
//        for(int i = 0 ; i < values.length ; i++){
//            head = insert(head, Integer.parseInt(values[i]));
//        }
//        display(head);
//        display(reverse(head, k));
//    }
//}
