package HackerRankLeetCodeQuestions;

public class LeetCode33SearchInRotatedSortedArray {

    static int binarySearchRotated(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){

                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }

            }else{

                if(nums[right] >= target && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args){

        // Input:

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        // Output:
        // 4

        int index = binarySearchRotated(nums,target);
        
        System.out.println(index);
    }
    
}
