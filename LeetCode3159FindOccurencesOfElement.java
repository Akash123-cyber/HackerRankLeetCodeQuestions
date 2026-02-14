package HackerRankLeetCodeQuestions;

public class LeetCode3159FindOccurencesOfElement {


    static int[] findOccurence(int[] nums, int[] queries, int x){

        int[] arr = new int[nums.length +1];

        int j = 1;

        for(int i = 0; i < nums.length; i++){
            
            if(nums[i]==x){
                arr[j++] = i;
            }
        }

        for(int k = j; k < arr.length; k++){
            arr[k] = -1;
        }

        int[] occ = new int[queries.length];
        for(int i = 0; i < queries.length; i++){

            if(queries[i] <= nums.length){
                occ[i] = arr[queries[i]];
            }else{
                occ[i] = -1;
            }
        }

        return occ;
    }

    public static void main(String[] args){

        //**Input:**

        int[]  nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;

        // Output:
        // [0, -1, 2, -1]


        int[] occ = findOccurence(nums, queries, x);

        System.out.print("Occurences : ");
        for(int o : occ){
            System.out.print(o+" ");
        }
        System.out.println();
    }
    
}
