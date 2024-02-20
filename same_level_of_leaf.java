class Solution
{
    boolean check(Node root)
    {
        int result = 0;
        if(root == null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                Node current = q.poll();
                if(current.left == null && current.right == null){
                    if(result == 0) result = level;
                    else if(result != level) return false;
                }
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
        return true;
    }
}
