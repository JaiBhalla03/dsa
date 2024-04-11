class Solution{
public:
    int maxEqualSum(int N1,int N2,int N3,vector<int> &S1,vector<int> &S2,vector<int> &S3){
        int sum1 = 0 , sum2 = 0 , sum3 = 0;
        int top1 = 0 , top2 = 0 , top3 = 0;
        for(int i = 0  ; i < N1 ; i++){
            sum1 += S1[i];
        }
        for(int i = 0  ; i < N2 ; i++){
            sum2 += S2[i];
        }
        for(int i = 0  ; i < N3 ; i++){
            sum3 += S3[i];
        }
        while(1){
            //if any of the stacks are empty

            if(top1 == N1 || top2 == N2 || top3 == N3){
                return 0;
            }
            if(sum1 == sum2 && sum2 == sum3){
                return sum1;
            }
            //now is the logic to find the maximum sum 
            if(sum1 >= sum2 && sum1 >= sum3){
                sum1 -= S1[top1++];
            }
            else if(sum2 >= sum1 && sum2 >= sum3){
                sum2 -= S2[top2++];
            }
            else if(sum3 >= sum1 && sum3 >= sum2){
                sum3 -= S3[top3++];
            }
        }
        return -1;
    }
};