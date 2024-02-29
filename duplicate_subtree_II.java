class Solution{
    public String helper(Node root, HashMap<String, Integer> map, List<Node> ans){
        if(root == null) return "N";
        String s = Integer.toString(root.data) + "," + helper(root.left, map, ans) + "," + helper(root.right, map, ans);
        if(map.containsKey(s) && map.get(s) == 1) ans.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }

    public List<Node> printAllDups(Node root)
    {
        List<Node> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, map, ans);
        ans.sort((a,b) -> a.data - b.data);
        return ans;
    }

}