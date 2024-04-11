class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        //first check if the intervals are not empty
        if(intervals.size() == 0) return vector<vector<int>>();
        //sort the intervals on the basis of the starting values 
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b){
            return a[0] < b[0];
        });
        stack<vector<int>> mergeStack;
        vector<vector<int>> mergeIntervals;
        mergeStack.push(intervals[0]);
        for(int i = 1 ; i < intervals.size() ; i++){
            vector<int> current = intervals[i];
            vector<int> &top = mergeStack.top();
            //if the current starting point overlaps in the top value of the stack then update the top end value
            if(top[1] >= current[0]){
                top[1] = max(top[1], current[1]);
            }
                //if it does not then just push it in the stack
            else{
                mergeStack.push(current);
            }
        }

        while(!mergeStack.empty()){
            mergeIntervals.insert(mergeIntervals.begin(), mergeStack.top());
            mergeStack.pop();
        }

        return mergeIntervals;
    }
};