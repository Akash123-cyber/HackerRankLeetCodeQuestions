package HackerRankLeetCodeQuestions;

public class OptimisedLeetCode34FindFirstAndLastPositions {

    static int firstOccurence(int[] nums, int target){

        int result = -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                result = mid;
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return result;

    }

    static int lastOccurence(int[] nums, int target){
        
        int result = -1;

        int left = 0;
        int right = nums.length;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                result = mid;
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }

    static int[] searchRange(int[] nums, int target){

        int[] arr = {-1, -1};

        int first = firstOccurence(nums, target);

        if(first == -1){
            return arr;
        }

        int last = lastOccurence(nums, target);

        arr[0] = first;
        arr[1] = last;

        return arr;
    }
    
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(nums, target);

        for(int r : result){
            
            System.out.print(r+" ");
        }

        System.err.println();
    }
    
}
