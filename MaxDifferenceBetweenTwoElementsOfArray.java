package HackerRankLeetCodeQuestions;

public class MaxDifferenceBetweenTwoElementsOfArray {

    public static void main(String[] args){

        int[] arr = {9,5,8,12,2,3,7,4};

        int maxDiff = 0;
        int max = 0;

        for(int i = arr.length - 1; i >= 0; i--){

            max = Math.max(max, arr[i]);
            maxDiff = Math.max(maxDiff, max - arr[i]);
        }

        System.out.println("Max Difference: "+maxDiff);
    }
    
}
