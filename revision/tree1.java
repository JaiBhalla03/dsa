//import java.util.*;
//
///*
//* 1 depth of the tree (DONE)
//* 2 reverse level order  (DONE)
//* 3 inverse of the binary tree  (DONE)
//* 4 is subtree  (DONE)
//* 5 left view  (DONE)
//* 6 right view (DONE)
//* 7 zig zag (DONE)
//* 8 mirrorify  (DONE)
//* 9 boundary traversal  (DONE)
//* 10 vertical order  (DONE)
//* 11 top (DONE)
//* 12 bottom (DONE)
//* 13 check if the leaves are the same level  (DONE)
//* 14 check if the tree is balanced  (DONE)
//* 15 is same tree  (DONE)
//* 16 height of the tree (DONE)
//* 17 diameter of the tree  (DONE)
//* 18 diagonal traversal (DONE)
//* 19 isomorphic tree  (DONE)
//* 20 sum tree  (DONE)
//* 21 construct tree from inorder and preorder (DONE)
//* 22 construct tree from strings with bracket (DONE)
//* 23 lca of two nodes  (DONE)
//* 24 minimum distance between 2 nodes  (DONE)
//* 25 minimum swap to convert binary to bst
//* 26 duplicate subtree in binary tree (DONE)
//* 27 check if the graph is a tree or not
//* 28 duplicate subtree  (DONE)
//* 29 kth ancestor of a node in binary tree (DONE)
//* 30 construct tree from inorder and postorder (DONE)
//* */
//
//public class tree1 {
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
//
//    static class Pair{
//        Node a;
//        int b;
//        public Pair(Node a, int b){
//            this.a = a;
//            this.b = b;
//        }
//    }
//
//    static class Height{
//        int h;
//    }
//
//    public static Node buildTree(String str){
//        if(str == null || str.isEmpty()) return null;
//        String[] values = str.split(" ");
//        Node root = new Node(Integer.parseInt(values[0]));
//        if(values.length == 1) return root;
//        Queue<Node> q = new LinkedList<>();
//        q.offer(root);
//        int i = 1;
//        while(!q.isEmpty()){
//            Node curr = q.poll();
//            if(i < values.length && !values[i].equals("-1")){
//                curr.left = new Node(Integer.parseInt(values[i]));
//                q.offer(curr.left);
//            }
//            i++;
//            if(i < values.length && !values[i].equals("-1")){
//                curr.right = new Node(Integer.parseInt(values[i]));
//                q.offer(curr.right);
//            }
//            i++;
//        }
//        return root;
//    }
//    public static void inorder(Node root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//
//    //depth of the tree
//    public static int depth(Node root){
//        if(root == null) return 0;
//        return 1 + Math.max(depth(root.left), depth(root.right));
//    }
//
//    //function of reverse level order
//    public static void reverseLevelOrder(Node root){
//        Queue<Node> q = new LinkedList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> l = new ArrayList<>();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                l.add(node.data);
//                if(node.left != null){
//                    q.offer(node.left);
//                }
//                if(node.right != null){
//                    q.offer(node.right);
//                }
//            }
//            ans.add(l);
//        }
//        for(int i = ans.size() - 1 ; i >= 0 ; i--){
//            for(Integer x : ans.get(i)){
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    //function for the inverse of the binary tree
//    public static void inverse(Node root){
//        if(root == null){
//            return;
//        }
//        if(root.left != null && root.right != null) {
//            int temp = root.left.data;
//            root.left.data = root.right.data;
//            root.right.data = temp;
//        }
//        if(root.left != null) inverse(root.left);
//        if(root.right != null) inverse(root.right);
//
//    }
//
//    //function to check if the same tree
//    public static boolean isSameTree(Node a, Node b){
//        if(a == null && b == null) return true;
//        if(a == null || b == null) return false;
//        return a.data == b.data && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
//    }
//
//    //function to check if the subtree
//    public static boolean isSubTree(Node root, Node child){
//        if(child == null) return true;
//        if(root == null) return false;
//        if(isSameTree(root, child)) return true;
//        return isSubTree(root.left, child) || isSubTree(root.right, child);
//    }
//
//    //function to the left right and zig zag view
//
//    public static void mixed(Node root){
//        Queue<Node> q = new LinkedList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> l = new ArrayList<>();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                l.add(node.data);
//                if(node.left != null){
//                    q.offer(node.left);
//                }
//                if(node.right != null){
//                    q.offer(node.right);
//                }
//            }
//            ans.add(l);
//        }
//        // bus ismai change kar na hai
//        for(int i = ans.size() - 1 ; i >= 0 ; i--){
//            for(Integer x : ans.get(i)){
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    //function to mirrorify the tree
//    public static void mirrorify(Node root){
//        if(root == null){
//            return;
//        }
//        Node temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        if(root.left != null) mirrorify(root.left);
//        if(root.right != null) mirrorify(root.right);
//    }
//
//    // function to check if the tree is balanced
//    public static int helper(Node root){
//        if(root == null) return 0;
//        int lh = helper(root.left);
//        if(lh == -1) return -1;
//        int rh = helper(root.right);
//        if(rh == -1) return -1;
//        if(Math.abs(lh - rh) > 1) return -1;
//        return Math.max(lh, rh) + 1;
//    }
//    public static boolean isBalanced(Node root){
//        return helper(root) >= 0;
//    }
//
//    //function to print the boundary
//    public static boolean isLeaf(Node root){
//        return root.left == null && root.right == null;
//    }
//
//    public static void leftBoundary(Node root){
//        Node node = root.left;
//        while(node != null){
//            if(!isLeaf(node)) System.out.print(node.data + " ");
//            if(node.left != null) node = node.left;
//            else node = node.right;
//        }
//    }
//
//    public static void leafBoundary(Node root){
//        if(root == null) return;
//        leafBoundary(root.left);
//        if(isLeaf(root)) System.out.print(root.data + " ");
//        leafBoundary(root.right);
//    }
//
//    public static void rightBoundary(Node root){
//        Node node = root.right;
//        Stack<Integer> st = new Stack<>();
//        while(node != null){
//            if(!isLeaf(node)) st.push(node.data);
//            if(node.right != null) node = node.right;
//            else node = node.left;
//        }
//        while(!st.isEmpty()){
//            System.out.print(st.pop() + " ");
//        }
//    }
//    public static void boundary(Node root){
//        System.out.print(root.data + " ");
//        leftBoundary(root);
//        leafBoundary(root);
//        rightBoundary(root);
//        System.out.println();
//    }
//
//    //function for the vertical traversal
//    public static void vertical(Node root){
//        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
//        int hd = 0, mn = 0, mx = 0;
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(root, hd));
//        while(!q.isEmpty()){
//            Pair p = q.poll();
//            Node node = p.a;
//            hd = p.b;
//            if(!mp.containsKey(hd)) mp.put(hd, new ArrayList<>());
//            mp.get(hd).add(node.data);
//            if(node.left != null){
//                q.add(new Pair(node.left, hd - 1));
//            }
//            if(node.right != null){
//                q.add(new Pair(node.right, hd + 1));
//            }
//            if(hd < mn) mn = hd;
//            if(hd > mx) mx = hd;
//        }
//        for(int i = mn ; i <= mx ; i++){
//            for(int x : mp.get(i)) {
//                System.out.print(x + " ");
//            }
//        }
//        System.out.println();
//    }
//    //function for the top view
//    public static void topView(Node root){
//        int hd = 0, mn = 0, mx = 0;
//        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(root, hd));
//        while(!q.isEmpty()){
//            Pair p = q.poll();
//            Node node = p.a;
//            hd = p.b;
//            if(!mp.containsKey(hd)) mp.put(hd, new ArrayList<>());
//            mp.get(hd).add(node.data);
//            if(node.left != null){
//                q.add(new Pair(node.left, hd-1));
//            }
//            if(node.right != null){
//                q.add(new Pair(node.right, hd+1));
//            }
//            if(hd < mn) mn = hd;
//            if(hd > mx) mx = hd;
//        }
//        for(int i = mn ; i <= mx ; i++){
//            System.out.print(mp.get(i).get(0) + " ");
//        }
//    }
//    //function for the bottom view
//    public static void bottomView(Node root){
//        int hd = 0, mn = 0, mx = 0;
//        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(root, hd));
//        while(!q.isEmpty()){
//            Pair p = q.poll();
//            Node node = p.a;
//            hd = p.b;
//            if(!mp.containsKey(hd)) mp.put(hd, new ArrayList<>());
//            mp.get(hd).add(node.data);
//            if(node.left != null){
//                q.add(new Pair(node.left, hd-1));
//            }
//            if(node.right != null){
//                q.add(new Pair(node.right, hd+1));
//            }
//            if(hd < mn) mn = hd;
//            if(hd > mx) mx = hd;
//        }
//        for(int i = mn ; i <= mx ; i++){
//            System.out.print(mp.get(i).get(mp.get(i).size() - 1) + " ");
//        }
//    }
//
//    //function for the diagonal traversal
//    public static void diagonal(Node root){
//        List<Integer> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            Node node = q.poll();
//            if(node.left != null) q.add(node.left);
//            while(node != null){
//                ans.add(node.data);
//                node = node.right;
//            }
//        }
//        for(Integer x : ans){
//            System.out.print(x + " ");
//        }
//        System.out.println();
//    }
//
//    //diameter for the tree
//    public static int util(Node root, Height height){
//        Height lh = new Height();
//        Height rh = new Height();
//        if(root == null){
//            height.h = 0;
//            return 0;
//        }
//        int ld = util(root.left, lh);
//        int rd = util(root.right, rh);
//        height.h = Math.max(lh.h, rh.h) + 1;
//        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
//    }
//    public static int diameter(Node root){
//        Height height = new Height();
//        height.h = 0;
//        return util(root, height);
//    }
//
//
//    //check if the leafs are at the same level
//    public static void isSameLevel(Node root){
//        int level = -1;
//        int result = 0;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        boolean flag = true;
//        while(!q.isEmpty()){
//            int size = q.size();
//            level--;
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                if(node.left == null && node.right == null){
//                    if(result == 0) result = level;
//                    else if(level != result) flag = false;
//                }
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//        }
//        if(flag) System.out.println("the leaves are at the same level");
//        else System.out.println("the leaves are at different level");
//    }
//    //give the sum tree
//    public static int sumTree(Node root){
//        if(root == null) return 0;
//        int a = sumTree(root.left);
//        int b = sumTree(root.right);
//        int x = root.data;
//        root.data = a + b;
//        return a + b + x;
//    }
//    //check if the trees are isomorphic
//
//    public static boolean isIsomorphic(Node root1, Node root2){
//        if(root1 == null && root2 == null) return true;
//        if(root1 == null || root2 == null) return false;
//        if(root1.data != root2.data) return false;
//        boolean a = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
//        boolean b = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
//        return a || b;
//    }
//
//    //function to print the lca of the two nodes
//    public static Node lca(Node root, int n1, int n2){
//        if(root == null) return null;
//        if(root.data == n1 || root.data == n2) return root;
//        Node leftLCA = lca(root.left, n1, n2);
//        Node rightLCA = lca(root.right, n1, n2);
//        if(leftLCA != null && rightLCA != null) return root;
//        return leftLCA != null ? leftLCA : rightLCA;
//    }
//    //function to print minimum distance between two nodes
//    public static int distance(Node root, int a, int level){
//        if(root == null) return -1;
//        if(root.data == a) return level;
//        int left = distance(root.left, a, level+1);
//        if(left != -1) return left;
//        return distance(root.right, a, level + 1);
//    }
//    public static int minDistance(Node root, int a, int b){
//        Node lca = lca(root, a, b);
//        int d1 = distance(lca, a, 0);
//        int d2 = distance(lca, b, 0);
//        System.out.println(d1 + " " + d2);
//        return d1 + d2;
//    }
//
//    //function to find the kth ancestor of the binary tree
//    public static int len = 0;
//    public static void length(Node root){
//        if(root == null){
//            return;
//        }
//        length(root.left);
//        len++;
//        length(root.right);
//    }
//    public static int kthAncestor(Node root, int k, int node) {
//        length(root);
//        int[] parent = new int[len + 1];
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        parent[root.data] = -1;
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            if (curr.left != null) {
//                q.add(curr.left);
//                parent[curr.left.data] = curr.data;
//            }
//            if (curr.right != null) {
//                q.add(curr.right);
//                parent[curr.right.data] = curr.data;
//            }
//        }
//        int count = 0;
//
//        while (node != -1) {
//            node = parent[node];
//            count++;
//            if (count == k) return node;
//        }
//        return -1;
//    }
//
//    //function to create a tree from string with brackets
//    public static Node fromString(String s, int[] start){
//        if(s == null || s.isEmpty() || start[0] > s.length()) return null;
//        boolean neg = false;
//        if(s.charAt(start[0]) == '-'){
//            start[0]++;
//            neg = true;
//        }
//        int num = 0;
//        int count = 0;
//        while(start[0] < s.length() && Character.isDigit(s.charAt(start[0]))){
//            int digit = Character.getNumericValue(s.charAt(start[0]));
//            start[0]++;
//            num = num*10 + digit;
//            count++;
//        }
//        if(neg) num = -num;
//        Node node = null;
//        if(count > 0) node = new Node(num);
//        if(start[0] < s.length() && s.charAt(start[0]) == '('){
//            start[0]++;
//            node.left = fromString(s, start);
//        }
//        if(start[0] < s.length() && s.charAt(start[0]) == ')'){
//            start[0]++;
//            return node;
//        }
//        if(start[0] < s.length() && s.charAt(start[0]) == '('){
//            start[0]++;
//            node.right = fromString(s, start);
//        }
//        if(start[0] < s.length() && s.charAt(start[0]) == ')'){
//            start[0]++;
//            return node;
//        }
//        return node;
//    }
//    public static Node buildFromString(String s){
//        int[] start = new int[]{0};
//        return fromString(s, start);
//    }
//
//    //function to construct the tree from inorder and preorder
//    public static int search(int[] arr, int start, int end, int x){
//        for(int i = start ; i <= end ; i++){
//            if(arr[i] == x) return i;
//        }
//        return -1;
//    }
//    public static Node preorderInorderHelper(int[] inorder, int[] preorder, int start, int end, int[] index){
//        if(start > end) return null;
//        int n = preorder[index[0]];
//        index[0]++;
//        Node node = new Node(n);
//        if(start == end) return node;
//        int pos = search(inorder, start, end, n);
//        node.left = preorderInorderHelper(inorder, preorder, start, pos - 1, index);
//        node.right = preorderInorderHelper(inorder, preorder, pos + 1, end, index);
//        return node;
//    }
//    public static Node preorderInorder(int[] inorder, int[] preorder){
//        int[] index = new int[]{0};
//        return preorderInorderHelper(inorder, preorder, 0, preorder.length - 1, index);
//    }
//
//    //function to construct the tree from inorder and postorder
//    public static Node postorderInorderHelper(int[] inorder, int[] postOrder, int start, int end, int[] index){
//        if(start > end) return null;
//        int n = postOrder[index[0]];
//        index[0]--;
//        Node node = new Node(n);
//        if(start == end) return node;
//        int pos = search(inorder, start, end, n);
//        node.right = postorderInorderHelper(inorder, postOrder, pos + 1, end, index);
//        node.left = postorderInorderHelper(inorder, postOrder, start, pos - 1, index);
//        return node;
//    }
//
//    public static Node postorderInorder(int[] inorder, int[] postOrder){
//        int[] index = new int[]{postOrder.length - 1};
//        return postorderInorderHelper(inorder, postOrder, 0, postOrder.length - 1, index);
//    }
//
//    //function to check is the binary tree contains a duplicate subtree
//    public static String duplicateSubtreeHelper(Node root, Map<String, Integer> mp){
//        if(root == null) return "$";
//        StringBuilder curr = new StringBuilder();
//        curr.append("#").append(root.data);
//        curr.append(duplicateSubtreeHelper(root.left, mp));
//        curr.append(duplicateSubtreeHelper(root.right, mp));
//        String serialized = curr.toString();
//        mp.put(serialized, mp.getOrDefault(serialized, 0) + 1);
//        return serialized;
//    }
//    public static boolean duplicateSubtree(Node root){
//        Map<String, Integer> mp = new HashMap<>();
//        duplicateSubtreeHelper(root, mp);
//        for(Map.Entry<String, Integer> e : mp.entrySet()){
//            if(e.getValue() > 1) return true;
//        }
//        return false;
//    }
//
//    // function to print all the duplicate tree in a binary
//    public static String solve(Node root, Map<String, Integer> mp, List<Node> ans){
//        if(root == null) return "N";
//        String curr = root.data + "," + solve(root.left, mp, ans) + "," + solve(root.right, mp, ans);
//        if(mp.containsKey(curr) && mp.get(curr) == 1) ans.add(root);
//        mp.put(curr, mp.getOrDefault(curr, 0) + 1);
//        return curr;
//    }
//    public static void printAllDuplicate(Node root){
//        List<Node> ans = new ArrayList<>();
//        Map<String, Integer> mp = new HashMap<>();
//        solve(root, mp, ans);
//        ans.sort((a, b)->(a.data - b.data));
//        for(Node node : ans){
//            reverseLevelOrder(node);
//        }
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        Node root = buildTree(str);
//        printAllDuplicate(root);
//        /*
//               1
//              / \
//             2   2
//        */
//
//    }
//}
