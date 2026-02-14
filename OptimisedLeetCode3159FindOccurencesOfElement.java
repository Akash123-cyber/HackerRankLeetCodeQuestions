package HackerRankLeetCodeQuestions;

public class OptimisedLeetCode3159FindOccurencesOfElement {

    static int[] findOccurence(int[] nums, int[] queries, int x){

        int j = 0;

        for(int i = 0; i < nums.length; i++){

            int d = nums[i];
            nums[i] = -1;

            if(d == x){
                nums[j++] = i;
            }
        }

        for(int i = 0; i < queries.length; i++){

            int occ = queries[i] - 1;

            if(occ < nums.length){

                queries[i] = nums[occ];
            }else{
                queries[i] = -1;
            }
        }
        return queries;

    }

    public static void main(String[] args){

        //**Input:**

        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        int x = 1;

        // Output:
        // [0, -1, 2, -1]

        int[] Occurences = findOccurence(nums, queries, x);

        System.out.print("Occurences: ");
        for(int o: Occurences){
            System.out.print(o+" ");
        }

        System.out.println();

    }
    
}
