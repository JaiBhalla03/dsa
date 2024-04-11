class Height {
    int h;
}

class Solution {
    // Function to return the diameter of a Binary Tree.
    int util(Node root, Height height){
        Height lh = new Height();
        Height rh = new Height();
        if(root == null){
            height.h = 0;
            return 0;
        }
        int ldiameter = util(root.left, lh);
        int rdiameter = util(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
    int diameter(Node root) {
        Height height = new Height();
        return util(root, height);
    }
}
