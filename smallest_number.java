class Solution{
    static String smallestNumber(int S, int D){
        String ans = "";
        int arr[] = new int[D];
        if(S == 0){
            return "-1";
        }
        if(S > 9*D){
            return "-1";
        }
        S-=1;
        for(int i = D-1 ; i>0 ; i--){
            if(S > 9){
                arr[i] = 9;
                S -= 9;
            }
            else{
                arr[i] = S;
                S = 0;
            }
        }
        arr[0] = S + 1;
        for(int i = 0 ; i < D ; i ++){
            ans += Integer.toString(arr[i]);
        }
        return ans;
    }
}