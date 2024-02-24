class Solution
{
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static class pair{
        Node first;
        int second;
        pair(Node first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        Queue<pair> q = new ArrayDeque<>();
        int hd = 0;
        int mn = 0; int mx = 0;
        q.add(new pair(root, hd));
        while(q.size() > 0){
            pair temp = q.remove();
            hd = temp.second;
            Node node = temp.first;
            if(!m.containsKey(hd)) m.put(hd, new ArrayList<>());
            m.get(hd).add(node.data);
            if(node.left != null){
                q.add(new pair(node.left, hd-1));
            }
            if(node.right != null){
                q.add(new pair(node.right, hd+1));
            }
            if(mn > hd) mn = hd;
            else if(hd > mx) mx = hd;
        }
        for(int i = mn ; i <= mx ; i++){
            ArrayList<Integer> temp = m.get(i);
            ans.add(temp.get(0));
        }
        return ans;
    }
}