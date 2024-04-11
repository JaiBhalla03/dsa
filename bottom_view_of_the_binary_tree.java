class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    static class pair{
        Node first;
        int second;
        pair(Node first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        Queue<pair> q = new ArrayDeque<>();
        int hd = 0; int mn = 0; int mx = 0;
        q.add(new pair(root, hd));
        while(q.size() > 0){
            pair temp = q.remove();
            Node node = temp.first;
            hd = temp.second;
            if(!m.containsKey(hd)) m.put(hd, new ArrayList<>());
            m.get(hd).add(node.data);
            if(node.left != null){
                q.add(new pair(node.left, hd - 1));
            }
            if(node.right != null){
                q.add(new pair(node.right, hd + 1));
            }
            if(hd < mn){
                mn = hd;
            }
            else if(mx < hd){
                mx = hd;
            }
        }
        for(int i = mn ; i <= mx ; i++){
            ArrayList<Integer> temp = m.get(i);
            ans.add(temp.get(temp.size() - 1));
        }
        return ans;
    }
}