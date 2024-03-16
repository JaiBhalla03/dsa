class Solution {
    public int gcd(int n1, int n2){
        if(n2 == 0) return n1;
        return gcd(n2, n1%n2);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int ans = numsDivide[0];
        for(int i = 1 ; i < numsDivide.length ; i++){
            ans = gcd(ans, numsDivide[i]);
        }
        int count = 0;
        int minAns = ans;
        boolean flag = false;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < ans && ans % nums[i] == 0) minAns = Math.min(minAns, nums[i]);

        }
        System.out.println(minAns);

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < minAns) {
                count++;
            }
            if(nums[i] == minAns) flag = true;
        }
        if(!flag) return -1;
        return count == 0 ? 0 : count;
    }
}