class Solution {

    public String solve(Node root, HashMap<String, Integer> m) {
        if (root == null) return "$";
        String curr = "#";
        if (root.left == null && root.right == null) {
            curr = String.valueOf(root.data);
            return curr;
        }

        curr += String.valueOf(root.data);
        curr += "#";
        curr += solve(root.left, m);
        curr += "#";
        curr += solve(root.right, m);
        curr += "#";
        m.put(curr, m.getOrDefault(curr, 0) + 1);
        return curr;
    }

    int dupSub(Node root) {
        HashMap<String, Integer> m = new HashMap<>();
        solve(root, m);
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() >= 2) return 1;
        }
        return 0;
    }
}