import java.util.*;
/*
* 1. sort linked list of 0 1 2
* 2. multiply linked list
* 3. remove nth node from the list
* 4. reorder list
* 5. detect and remove loop
* */

public class prog6_10 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //function to insert
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
    //sort 0 1 2
    public static void sort(Node head){
        int[] count = {0, 0, 0};
        Node temp = head;
        while(temp != null){
            count[temp.data]++;
            temp = temp.next;
        }
        int i = 0;
        temp = head;
        while(temp != null){
            if(count[i] == 0){
                ++i;
            }
            else{
                temp.data = i;
                temp = temp.next;
                --count[i];
            }
        }
    }
    //multiply linked list
    public static int multiple(Node head1, Node head2){
        int num1 = 0;
        int num2 = 0;
        Node l1 = head1;
        Node l2 = head2;
        while(l1 != null && l2 != null){
            if(l1 != null){
                num1 = num1*10 + l1.data;
                l1 = l1.next;
            }
            if(l1 != null){
                num2 = num2*10 + l2.data;
                l2 = l2.next;
            }
        }
        return num1*num2;
    }

    //remove nth node from end
    public static void remove(Node head, int n){
        if(n == 1){
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = head;
        while(n != 1){
            prev = curr;
            curr = curr.next;
            n--;
        }
        prev.next = prev.next.next;
        return;
    }

    //reorder list
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
    public static Node reorder(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = head;
        Node ans = new Node(-1);
        Node temp = ans;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node first = head;

        Node second = reverse(slow);

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
    //create a loop at kth position
    public static void createLoop(Node head, int k){
        Node temp = head;
        while(k != 1){
            temp = temp.next;
            k--;
        }
        Node joinEnd = temp;
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = joinEnd;
    }
    //detect and remove loop
    public static void removeLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        // if the loop is there remove it
        if(slow == fast){
            slow = head;
            if(fast == slow){
                while(fast.next != slow){
                    fast = fast.next;
                }
            }
            else{
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            fast.next = null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        Node head = null;
        for(int i = 0 ; i<values.length ; i++){
            head = insert(head, Integer.parseInt(values[i]));
        }

        display(head);
        head = reorder(head);
        display(head);
        createLoop(head, 2);
        removeLoop(head);
        display(head);
    }
}
