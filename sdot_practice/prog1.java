///*
//Example
//Input
//3
//1 2 4
//3
//1 3 4
//Output
//1 1 2 3 4 4
//* */
//
//import java.util.*;
//
//public class prog1 {
//    static class Node{
//        int data;
//        Node next;
//        public Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    public static Node insert(Node head ,int data){
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
//    public static Node merge(Node a, Node b){
//        if(a == null) return b;
//        if(b == null) return a;
//        Node result = null;
//        if(a.data < b.data){
//            result = a;
//            result.next = merge(a.next, b);
//        }
//        else{
//            result = b;
//            result.next = merge(a, b.next);
//        }
//        return result;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        Node head1 = null;
//        Node head2 = null;
//        int n1 = sc.nextInt();
//        for(int i = 0 ; i < n1 ; i++){
//            int x = sc.nextInt();
//            head1 = insert(head1, x);
//        }
//        int n2 = sc.nextInt();
//        for(int i = 0 ; i < n2 ; i++){
//            int x = sc.nextInt();
//            head2 = insert(head2, x);
//        }
//        display(merge(head1, head2));
//    }
//}
