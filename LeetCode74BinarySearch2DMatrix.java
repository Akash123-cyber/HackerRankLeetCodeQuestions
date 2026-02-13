package HackerRankLeetCodeQuestions;

public class LeetCode74BinarySearch2DMatrix {

    static int[] binarySearch(int[][] matrix, int target){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols - 1;

        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;

        while (left <= right) {

            int mid = left + (right - left)/2;

            int midRows = mid/cols;

            int midCols = mid%cols;

            if(matrix[midRows][midCols] == target){
                arr[0] = midRows;
                arr[1] = midCols;

                return arr;
            
            }else if(matrix[midRows][midCols] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            
        }

        return arr;
    }


    public static void main(String[] args){

        int[][] matrix = {
            {1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 10;

        int[] arr = binarySearch(matrix, target);
        
        System.out.println("Target exists at indexes: "+arr[0]+" and "+arr[1]);
    }
    
}
