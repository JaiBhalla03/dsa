class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //here we will be using the monotonic pattern
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack();
        for(int i = 0 ; i < n*2 ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                res[st.pop()] = nums[i%n];
            }
            st.push(i%n);
        }
        return res;
    }
}

//without the circulat motion
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] nums, int n)
    {

        long[] res = new long[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                res[st.pop()] = nums[i];
            }
            st.push(i);
        }
        return res;
    }
}