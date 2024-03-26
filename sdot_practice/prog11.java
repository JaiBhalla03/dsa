//import java.util.*;
//
///*
//Input: Linked List 1->2->3->4->5->6->7
//Output: A Balanced BST
//         4
//       /  \
//      2    6
//     / \  / \
//    1  3 5  7
//* */
//
//public class prog11 {
//    static class ListNode{
//        int data;
//        ListNode next;
//        public ListNode(int val){
//            this.data = val;
//            this.next = null;
//        }
//    }
//    static class TreeNode{
//        int data;
//        TreeNode left;
//        TreeNode right;
//        public TreeNode(int data){
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//    public static ListNode insert(ListNode head,int data){
//        if(head == null) return new ListNode(data);
//        ListNode end = head;
//        while(end.next != null) end = end.next;
//        end.next = new ListNode(data);
//        return head;
//    }
//    public static TreeNode createBst(List<Integer> arr, int start, int end){
//        if(start > end) return null;
//        int mid = (start + end)/2;
//        TreeNode node = new TreeNode(arr.get(mid));
//        node.left = createBst(arr, start, mid-1);
//        node.right = createBst(arr, mid+1, end);
//        return node;
//    }
//    public static void inorder(TreeNode root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//
//    public static void levelOrder(TreeNode root){
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0 ; i < size ; i++){
//                TreeNode node = q.poll();
//                System.out.print(node.data + " ");
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] values = sc.nextLine().split(" ");
//        ListNode head = null;
//        for(int i = 0 ; i < values.length ; i++){
//            head = insert(head, Integer.parseInt(values[i]));
//        }
//        List<Integer> arr = new ArrayList<>();
//        ListNode temp = head;
//        while(temp != null){
//            arr.add(temp.data);
//            temp = temp.next;
//        }
//        TreeNode root = createBst(arr, 0, arr.size()-1);
//        inorder(root);
//        System.out.println();
//        levelOrder(root);
//    }
//}
