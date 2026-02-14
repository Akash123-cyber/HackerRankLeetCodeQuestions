package HackerRankLeetCodeQuestions;

public class LeetCode34FindFirstAndLastPositions {

    static int[] searchRange(int[] nums, int target) {
        
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        boolean first = true;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == target){

                if(first){
                    arr[0] = i;
                    first = false;
                }

                arr[1] = i;
            }
        }

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
