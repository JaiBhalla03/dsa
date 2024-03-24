/*
* Example 2:
Input:
Enter the number of linkedlists (k):
3
Enter the size of linkedlist 1:
3
Enter the elements of linkedlist 1:
1 3 7
Enter the size of linkedlist 2:
2
Enter the elements of linkedlist 2:
2 4
Enter the size of linkedlist 3:
4
Enter the elements of linkedlist 3:
5 6 8 9
Output:
Merged Linked List:
1 2 3 4 5 6 7 8 9
* */
import java.util.*;

public class prog3 {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node insert(Node head ,int data){
        if(head == null) return new Node(data);
        Node end = head;
        while(end.next != null) end = end.next;
        end.next = new Node(data);
        return head;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node merge(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;
        Node result = null;
        if(a.data < b.data){
            result = a;
            result.next = merge(a.next, b);
        }
        else{
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    }
}
