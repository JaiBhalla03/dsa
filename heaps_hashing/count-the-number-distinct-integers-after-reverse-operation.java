class Solution {
    public int reverse(int num){
        int r = 0;
        while(num != 0){
            int d = num%10;
            r = r*10 + d;
            num /= 10;
        }
        return r;
    }
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            int rev = reverse(num);
            s.add(num);
            s.add(rev);
        }
        return s.size();
    }
}