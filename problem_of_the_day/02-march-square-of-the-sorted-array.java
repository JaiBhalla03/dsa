class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> l = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            l.add(nums[i]*nums[i]);
        }
        Collections.sort(l);
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = l.get(i);
        }
        return result;
    }
}