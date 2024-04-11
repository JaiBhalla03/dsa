//brute force
class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return n;
        if(n == 2) return -1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            arr.add(i);
        }
        int suml = 0;
        int sumr = 0;
        for(int i = 2 ; i < n ; i++){
            sumr += arr.get(i);
        }
        suml = arr.get(0);
        for(int i = 1 ; i < n-1 ; i++){
            if(suml == sumr) return i+1;
            suml += arr.get(i);
            sumr -= arr.get(i+1);
        }
        return -1;
    }
}

//optimised
class Solution {
    public int pivotInteger(int n) {
        int left = 0;
        int right = n;
        int fullSum = (n*(n+1))/2;
        while(left <= right){
            int mid = left + (right - left);
            int leftSum = (mid*(mid+1)/2);
            int rightSum = fullSum - leftSum + mid;
            if(leftSum == rightSum) return mid;
            else if(leftSum < rightSum){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}