class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums1.length ; i++){
            count[nums1[i]]++;
        }
        for(int i = 0 ; i < nums2.length ; i++){
            if(count[nums2[i]] > 0){
                ans.add(nums2[i]);
                count[nums2[i]] = 0;
            }
        }
        int size = ans.size();
        int[] result = new int[size];
        for(int i = 0 ; i < size ; i++){
            result[i] = ans.get(i);
        }
        return result;
    }

}