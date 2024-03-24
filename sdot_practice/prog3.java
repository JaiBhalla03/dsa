///*
//* Example 2:
//Input:
//Enter the number of linkedlists (k):
//3
//Enter the size of linkedlist 1:
//3
//Enter the elements of linkedlist 1:
//1 3 7
//Enter the size of linkedlist 2:
//2
//Enter the elements of linkedlist 2:
//2 4
//Enter the size of linkedlist 3:
//4
//Enter the elements of linkedlist 3:
//5 6 8 9
//Output:
//Merged Linked List:
//1 2 3 4 5 6 7 8 9
//* */
//import java.util.*;
//
//public class prog3 {
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
//    public static Node mergeKSorted(Node[] list, int K){
//        int last = K - 1;
//        while(last != 0){
//            int i = 0;
//            int j = last;
//            while(i < j){
//                list[i] = merge(list[i], list[j]);
//                i++;
//                j--;
//            }
//            if(i >= j){
//                last = j;
//            }
//        }
//        return list[0];
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Node[] list = new Node[n];
//        for(int i = 0 ; i < n ; i++){
//            int len = sc.nextInt();
//            Node head = null;
//            for(int j = 0 ;j < len ; j++){
//                int x = sc.nextInt();
//                head = insert(head, x);
//            }
//            display(head);
//            list[i] = head;
//        }
//        display(mergeKSorted(list, n));
//    }
//}
