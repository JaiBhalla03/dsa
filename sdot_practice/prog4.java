///*
//* solving the
//* reorder list
//* Example 2:
//Input: N = 4, List = {1, 2, 3, 4}
//* output {1,4,2,3}
//* even odd
//*Example 2:
//input: 2 → 1 → 6 → 4 → 8.
//output: 2 4 6 8 1
//* rotate list
//* Example
//Input-1
//Head: 10->20->30->40->50
//K: 2
//Output-1
//40->50->10->20->30
//* */
//import java.util.*;
//public class prog4 {
//    static class Node{
//        int data;
//        Node next;
//        public Node(int data) {
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
//        while(temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
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
//    //function to reorder the linked list
//    public static Node reorder(Node head){
//        Node ans = new Node(-1);
//        Node temp = ans;
//        Node slow = head;
//        Node fast = head;
//        Node prev = head;
//        while(fast != null && fast.next != null){
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        Node second = reverse(slow);
//        prev.next = null;
//        Node first = head;
//        while(first != null || second != null){
//            if(first != null){
//                temp.next = first;
//                first = first.next;
//                temp = temp.next;
//            }
//            if(second != null){
//                temp.next = second;
//                second = second.next;
//                temp = temp.next;
//            }
//        }
//        return ans.next;
//    }
//
//
//    //function to sort the linked list in even odd fashion
//    public static Node evenOdd(Node head){
//        Node evenStart = null;
//        Node oddStart = null;
//        Node evenEnd = null;
//        Node oddEnd = null;
//        Node temp = head;
//        while(temp != null){
//            if(temp.data % 2 == 0){
//                if(evenStart == null){
//                    evenStart = new Node(temp.data);
//                    evenEnd = evenStart;
//                }
//                else{
//                    evenEnd.next = new Node(temp.data);
//                    evenEnd = evenEnd.next;
//                }
//            }
//            else{
//                if(oddStart == null){
//                    oddStart = new Node(temp.data);
//                    oddEnd = oddStart;
//                }
//                else{
//                    oddEnd.next = new Node(temp.data);
//                    oddEnd = oddEnd.next;
//                }
//            }
//            temp = temp.next;
//        }
//        evenEnd.next = oddStart;
//        return evenStart;
//    }
//    public static int len(Node head){
//        if(head == null) return 0;
//        return 1 + len(head.next);
//    }
//    //function to rotate the linked list
//    public static Node rotateList(Node head, int k){
////        Input-1
////        Head: 10->20->30->40->50
////        K: 2
////        Output-1
////        40->50->10->20->30
//        if(k == 0 || k == len(head)) return head;
//        int l = len(head) - k;
//
//        Node ans = new Node(-1);
//        Node t = ans;
//        Node temp = head;
//        Node prev = head;
//        while(l != 0){
//            prev = temp;
//            temp = temp.next;
//            l--;
//        }
//
//        t.next = temp;
//        prev.next = null;
//        while(t.next != null) t = t.next;
//        t.next = head;
//        return ans.next;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] values = sc.nextLine().split(" ");
//        Node head = null;
//        for(int i = 0 ; i < values.length ; i++){
//            head = insert(head, Integer.parseInt(values[i]));
//        }
//        int k = sc.nextInt();
//        display(rotateList(head, k));
//    }
//}
