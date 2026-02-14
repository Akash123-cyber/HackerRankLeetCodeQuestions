package HackerRankLeetCodeQuestions;

public class OptimisedLeetCode240SearchA2DMatrix {

    static boolean searchMatrix(int[][] matrix, int target){

        int rows = matrix.length;
        int cols = matrix.length;

        int i = 0;
        int j = cols - 1;

        //Starting with top right

        while(i < rows && j >= 0){

            if(matrix[i][j] > target) j--;
            else if(matrix[i][j] < target) i++;
            else return true;
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

        int target = 20;

        boolean exists = searchMatrix(matrix, target);

        if (exists) {
            System.out.println("True Exists");
        }else{
            System.out.println("False Doesn't Exists");
        }
    }
    
}
