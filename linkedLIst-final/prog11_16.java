import java.util.*;
/*
* 1. intersection of the linked list
* 2. zigzag fashion
* 3. even odd linked list
* 4. delete node having greater value on the right side
* 5. rearrange a linked list in place
* */

public class prog11_16 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node insert(Node head, int data){
        if(head == null) return new Node(data);
        Node end = head;
        while(end.next != null){
            end = end.next;
        }
        end.next = new Node(data);
        return head;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void createIntersection(Node head1, Node head2, int intersectNodeVal) {
        Node intersectNode = null;
        Node temp = head1;
        while (temp.next != null) {
            if (temp.data == intersectNodeVal) {
                intersectNode = temp;
                break;
            }
            temp = temp.next;
        }
        if (intersectNode != null) {
            Node temp2 = head2;
            while (temp2.next != null) {
                temp2 = temp2.next;
            }
            temp2.next = intersectNode;
        }
    }
    //function that returns the intersection point of the linked list
    public static int intersection(Node head1, Node head2){
        Node a = head1;
        Node b = head2;
        while(a != b){
            a = (a == null) ? b : a.next;
            b = (b == null) ? a : b.next;
            if(a == null && b == null) return -1;
        }
        return a == null ? -1 : a.data;
    }
    //zigzag fashion

    public static void zigZag(Node head){
        Node curr = head;
        boolean flag = true;
        while(curr != null && curr.next != null){
            if(flag){
                if(curr.data > curr.next.data){
                    int temp =  curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            else{
                if(curr.data < curr.next.data){
                    int temp =  curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            curr = curr.next;
            flag = !flag;
        }
    }

    //odd even linked list
    public static Node oddEven(Node head){
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node temp = head;
        while(temp != null){
            int n = temp.data;
            if(n%2 == 0){
                if(evenStart == null){
                    evenStart = new Node(n);
                    evenEnd = evenStart;
                }
                else{
                    evenEnd.next = new Node(n);
                    evenEnd = evenEnd.next;
                }
            }
            else{
                if(oddStart == null){
                    oddStart = new Node(n);
                    oddEnd = oddStart;
                }
                else{
                    oddEnd.next = new Node(n);
                    oddEnd = oddEnd.next;
                }
            }
            temp = temp.next;
        }
        evenEnd.next = oddStart;
        return evenStart;
    }
    public static Node reverse(Node head){
        Node dummy = null;
        while(head != null){
            Node next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    //delete the node that have the greater value in the right size
    public static void deleteNode(Node head){

        Node curr = head;
        Node maxNode = head;
        Node temp;
        while(curr != null && curr.next != null){
            if(curr.next.data < maxNode.data){
                temp = curr.next;
                curr.next = temp.next;
                temp = null;
            }
            else{
                curr = curr.next;
                maxNode = curr;
            }
        }
    }

    //rearrange
    public static Node rearrange(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node first = head;
        Node second = reverse(slow);
        Node ans = new Node(-1);
        Node temp = ans;
        while(first != null && second != null){
            if(first != null){
                temp.next = first;
                first = first.next;
                temp = temp.next;
            }
            if(second != null){
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
        }
        return ans.next;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] values1 = sc.nextLine().split(" ");
        Node head1 = null;
        for(int i = 0 ; i < values1.length ; i++){
            head1 = insert(head1, Integer.parseInt(values1[i]));
        }
        display(head1);
        head1 = reverse(head1);
        deleteNode(head1);
        head1 = reverse(head1);
        display(head1);
        Node newNode = rearrange(head1);
        display(newNode);
    }
}
