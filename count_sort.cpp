class Solution{
public:
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    string countSort(string arr){
        vector<int> inputArray;
        for(auto x : arr){
            inputArray.push_back((int)(x) - 97);
        }
        int M = 0;
        for(int i = 0 ; i < inputArray.size() ; i++){
            M = max(M, inputArray[i]);
        }
        vector<int> countArray(M+1, 0);
        for(int i = 0 ; i < inputArray.size() ; i++){
            countArray[inputArray[i]]++;
        }
        for(int i = 1 ; i < countArray.size() ; i++){
            countArray[i] += countArray[i-1];
        }
        vector<int> outputArray(inputArray.size(), 0);
        for(int i = inputArray.size() - 1 ; i >= 0 ; i--){
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
        string result = "";
        for(int i = 0 ; i < outputArray.size() ; i++){
            result += (char)(outputArray[i] + 97);
        }
        return result;
    }
};