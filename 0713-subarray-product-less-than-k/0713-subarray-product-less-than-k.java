class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int left = 0, right = 0, product = 1, count = 0;

        while(right < nums.length){

            product *= nums[right];

            while(product >= k && left <= right){
                product /= nums[left++];
            }

            count += right - left + 1;

            right++;
        }

        return count;
        
    }
}