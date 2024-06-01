class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int normal = 0;
        int n = customers.length;
        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0) normal += customers[i];
        }
        //System.out.println(normal);
        int l = 0;
        int r = minutes;
        for(int i = 0 ; i < r ; i++){
            if(grumpy[i] == 1) normal += customers[i];
        }
        while(r < n){
            ans = Math.max(ans, normal);
            normal = (grumpy[r] == 1) ? (normal + customers[r]) : normal;
            normal = (grumpy[l] == 1) ? (normal - customers[l]) : normal;
            r++;
            l++;
        }
        ans = Math.max(ans, normal);
        return ans;
    }
}