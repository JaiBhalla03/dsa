import java.util.*;

public class prog17_20 {
    static class Node{
        int data;
        Node next;
        Node(){
            this.next = null;
        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //function for insertion
    public static Node insert(Node head, int data){
        if(head == null) return new Node(data);
        Node end = head;
        while(end.next != null) end = end.next;
        end.next = new Node(data);
        return head;
    }
    //function to display
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //helper function for the merge sort
    public static Node findMiddle(Node head){
        Node curr = head;
        if(curr == null || curr.next == null) return curr;
        Node slow = curr;
        Node fast = curr.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    //function does the merge sort of the linked list
    public static Node mergeSort(Node head){
        //if the linked list is empty or only one element then already sorted
        if(head == null || head.next == null) return head;
        Node middle = findMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        return merge(left, right);
    }

    //function that performs the merge of K sorted linked list
    public static Node mergeKSorted(Node[] lists, int K){
        int last = K - 1;
        while(last != 0){
            int i = 0;
            int j = last;
            while(i < j){
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
            }
            if(i > j){
                last = j;
            }
        }
        return lists[0];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("the following is the demonstration of merge sort!!");
        int n = sc.nextInt();
        Node head = null;
        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            head = insert(head, x);
        }
        display(head);
        Node newnode = mergeSort(head);
        display(newnode);
        System.out.println("The following is the demonstration of merge k sorted list ");
        System.out.print("Enter the values of K: ");
        int K = sc.nextInt();
        Node[] lists = new Node[K];

        for(int i = 0 ; i < K ; i++){
            lists[i] = null;
        }
        for(int i = 0 ; i < K ; i++){
            System.out.print("Enter the number of nodes in list-" + (i+1) + ": ");
            int len = sc.nextInt();
            for(int j = 0 ; j < len ; j++){
                int x = sc.nextInt();
                lists[i] =  insert(lists[i], x);
            }
        }
        Node finalNode = mergeKSorted(lists, K);
        display(finalNode);
    }
}
