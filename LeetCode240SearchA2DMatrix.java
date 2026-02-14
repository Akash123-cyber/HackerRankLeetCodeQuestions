package HackerRankLeetCodeQuestions;

public class LeetCode240SearchA2DMatrix {

    static boolean binarySearch(int[] arr, int target){

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 4, 7, 11, 15},  
            {2, 5, 8, 12, 19},  
            {3, 6, 9, 16, 22},  
            {10, 13, 14, 17,24},  
            {18, 21, 23, 26,30}
        };

        int target = 9;

        boolean exists = false;

        //optimised binary search
        for(int i = 0; i< matrix.length; i++){
            
            if(matrix[i][matrix[i].length - 1] > target){

                if(binarySearch(matrix[i], target)){
                    exists = true;
                    System.out.println("True target Exists");
                }
            }
        }

        if(!exists){
            System.out.println("Doesn't exists");
        }
        
    }
    
}
