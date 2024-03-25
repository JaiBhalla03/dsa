///*
//* zig zag traversal
//* sum root to leave
//*
//For example, consider the following Binary Tree.
//     6
//    / \
//   3  5
//  / \  \
// 2  5   4
//   / \
//  7  4
// There are 4 leaves, hence 4 root to leaf paths:
// Path Number
// 6->3->2 632
// 6->3->5->7 6357
// 6->3->5->4 6354
// 6->5>4 654
//Answer = 632 + 6357 + 6354 + 654 = 13997
//* */
//import java.util.*;
//
//public class prog6 {
//    static class Node{
//        int data;
//        Node left;
//        Node right;
//        public Node(int data){
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//    public static void inorder(Node root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//    //traverse the tree in zig zag manner
//
//    public static List<List<Integer>> zigzag(Node root){
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        boolean flag = true;
//        while(!q.isEmpty()){
//            List<Integer> temp = new ArrayList<>();
//            int size = q.size();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                temp.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//            if(flag){
//                ans.add(temp);
//            }
//            else{
//                List<Integer> t = new ArrayList<>();
//                for(int i = temp.size() - 1 ; i >= 0 ; i--) t.add(temp.get(i));
//                ans.add(t);
//            }
//            flag = !flag;
//        }
//        return ans;
//    }
//
//    //function that returns the sum of root to leaf
//    public static int sumToRoot(Node root, int val){
//        if(root == null) return 0;
//        val = val*10 + root.data;
//        if(root.left == null && root.right == null) return val;
//        return sumToRoot(root.left, val) + sumToRoot(root.right, val);
//    }
//    public static Node buildTree(String str){
//        if(str.length() == 0 || str.charAt(0) == 'N') return null;
//        String[] values = str.split(" ");
//        Node root = new Node(Integer.parseInt(values[0]));
//        Queue<Node> q = new LinkedList<>();
//        int i = 1;
//        q.add(root);
//        while(!q.isEmpty() && i < values.length){
//            Node node = q.poll();
//            if(!values[i].equals("N")){
//                node.left = new Node(Integer.parseInt(values[i]));
//                q.add(node.left);
//            }
//            i++;
//            if(i >= values.length) break;
//            if(!values[i].equals("N")){
//                node.right = new Node(Integer.parseInt(values[i]));
//                q.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        Node root = buildTree(str);
//        inorder(root);
//        System.out.println();
//        List<List<Integer>> l = zigzag(root);
//        for (List<Integer> integers : l) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println(sumToRoot(root, 0));
//    }
//}
