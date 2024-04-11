//brute force
class Solution {
public:
    vector<int> minOperations(string boxes) {
        vector<int> ones;
        vector<int> result;
        int sum;
        for(int i = 0 ; i<boxes.size() ; i++){
            if(boxes[i] == '1'){
                ones.push_back(i);
            }
        }
        for(int  i = 0 ; i < boxes.size() ;i++){
            sum = 0;
            for(int j = 0 ; j< ones.size(); j++){
                sum+=abs(i-ones[j]);
            }
            result.push_back(sum);
        }
        return result;
    }
};

//efficient approach
class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n = boxes.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        // vector<int> result;
        //filling the left array
        int count = boxes[0] - '0';
        for(int i = 1 ; i<n ; i++){
            left[i] = left[i-1] + count;
            count+=boxes[i] - '0';
        }
        count = boxes[n-1] - '0';
        for(int i = n-2 ; i>=0 ; i--){
            right[i] = right[i+1] + count;
            count+=boxes[i] - '0';
        }
        for(int i = 0 ; i<n ; i++){
            left[i] = left[i] + right[i];
        }
        return left;
    }
};