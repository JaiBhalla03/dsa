//using the union disjoint connection

class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        vector<int> ds(n+1, 0);
        //initializing the parent of each of the ds
        for(int i = 0 ; i <= n ; i++){
            ds[i] = i;
        }
        for(auto x : edges){
            int e1 = x[0];
            int e2 = x[1];
            int p1 = findParent(e1, ds);
            int p2 = findParent(e2, ds);
            if(p1 == p2) return x;
            else{
                ds[p2] = p1;
            }
        }
        return {};
    }
    int findParent(int element, vector<int> ds){
        if(ds[element] == element) return element;
        return findParent(ds[element], ds);
    }
};

//how to make it more the optimized we will be using the rank array

class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        vector<int> ds(n+1, 0);
        vector<int> rank(n+1 , 1);
        //initializing the parent of each of the ds
        for(int i = 0 ; i <= n ; i++){
            ds[i] = i;
        }
        for(auto x : edges){
            int e1 = x[0];
            int e2 = x[1];
            int p1 = findParent(e1, ds);
            int p2 = findParent(e2, ds);
            if(p1 == p2) return x;
            else{
                if(rank[p1] > rank[p2]){
                    ds[p2] = p1;
                }
                else if(rank[p2] > rank[p1]){
                    ds[p1] = p2;
                }
                else{
                    ds[p1] = p2;
                    rank[p2] ++;
                }
            }
        }
        return {};
    }
    int findParent(int element, vector<int> ds){
        if(ds[element] == element) return element;
        return findParent(ds[element], ds);
    }
};

//this while using the rank array