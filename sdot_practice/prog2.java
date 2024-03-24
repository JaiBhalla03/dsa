///*
//*
//*
//            Input
//            5
//            1 2 3 2 1
//            Output
//            true
//            Example 2
//            Input
//            6
//            10 20 30 10 50 30
//            Output:
//            false
//*
//* */
//import java.util.*;
//public class prog2 {
//    static class Node{
//        int data;
//        Node next;
//        public Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    public static Node insert(Node head , int data){
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
//    public static boolean isPalindrome(Node head){
//        //1 2 3 2 1
//        Node slow = head;
//        Node fast = head;
//        Node prev = head;
//        while(fast != null && fast.next != null){
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if(fast != null) slow = slow.next;
//        Node second = reverse(slow);
//        prev.next = null;
//        Node first = head;
//        while(first != null || second != null){
//            if(first.data != second.data) return false;
//            first = first.next;
//            second = second.next;
//        }
//        return true;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Node head = null;
//        for(int i = 0 ; i < n ; i++){
//            int x = sc.nextInt();
//            head = insert(head, x);
//        }
//        System.out.println(isPalindrome(head));
//    }
//}
