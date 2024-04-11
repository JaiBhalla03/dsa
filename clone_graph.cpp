/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* dfs(Node* cur, unordered_map<Node*, Node*> &mp){
        Node* clone = new Node(cur->val);
        mp[cur] = clone;
        vector<Node*> neighbours;
        for(auto it : cur->neighbors){
            if(mp.find(it) != mp.end()){
                neighbours.push_back(mp[it]);
            }
            else{
                neighbours.push_back(dfs(it, mp));
            }
        }
        clone->neighbors = neighbours;
        return clone;
    }
    Node* cloneGraph(Node* node) {
        unordered_map<Node*, Node*> mp;
        //edge case if the graph is null
        if(node == nullptr) return nullptr;
        //if the graph has only one node
        if(node->neighbors.size() == 0){
            Node* clone = new Node(node->val);
            return clone;
        }
        return dfs(node, mp);
    }
};