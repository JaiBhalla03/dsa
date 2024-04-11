public:
//Function to return a list of indexes denoting the required
void helper(vector<int> A, int sum, vector<vector<int>> &ans, vector<int> &r, int i){
    if(sum == 0){
        ans.push_back(r);
        return;
    }
    while(i < A.size() && sum - A[i] >= 0){
        r.push_back(A[i]);
        helper(A, sum - A[i], ans, r, i);
        i++;
        r.pop_back();
    }
}
//combinations whose sum is equal to given number.
vector<vector<int> > combinationSum(vector<int> &A, int B) {
    vector<vector<int>> ans;
    vector<int> r;
    sort(A.begin(), A.end());
    A.erase(unique(A.begin(), A.end()), A.end());
    helper(A, B, ans, r, 0);
    return ans;
}
};