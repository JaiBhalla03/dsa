/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node curr, Node node, Node[] visited){
        visited[node.val] = node;
        for(Node it : curr.neighbors){
            if(visited[it.val] == null){
                Node newNode =  new Node(it.val);
                node.neighbors.add(newNode);
                dfs(it, newNode, visited);
            }
            else{
                node.neighbors.add(visited[it.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        //if the node is null no need to clone
        if(node == null) return null;
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        visited[node.val] = copy;
        for(Node curr : node.neighbors){
            if(visited[curr.val] == null){
                Node newNode = new Node(curr.val);
                copy.neighbors.add(newNode);
                dfs(curr, newNode, visited);
            }
            else{
                copy.neighbors.add(visited[curr.val]);
            }
        }
        return copy;
    }
}