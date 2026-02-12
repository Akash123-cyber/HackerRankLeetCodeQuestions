package HackerRankLeetCodeQuestions;

public class SubarrayWithEqualSum {

    public static void main(String[] args){

        int[] arr = {3,4,-2,5,8,20,-10,8};

        int[] prefix = new int[arr.length];

        //preparing prefix sum array 
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // -----------------------------------------------------------------------------------------------------------------------------
        int d = 0; //inclusive division point of subarray
        for(d = 0; d < arr.length - 1; d++){
            //d < arr.length because we need to slice till one less than last element
            
//prefix[divisionPointORcurrentPrefixIndex] == prefix[lastIndex basically sum of entire array] - prefix[prefix sum till current index]
            if(prefix[d] == prefix[arr.length - 1] - prefix[d]){
                break;
            }
        }

        System.err.print("Sub Array1 "+0+" to "+d+" index: ");
        
        for(int i = 0; i<=d; i++){
            System.err.print(arr[i]+" ");
        }
        System.err.println("Sum = "+prefix[d]);
        
        System.err.print("Sub Array2 "+(d+1)+" to "+(arr.length - 1 )+" index: ");
        
        for(int i = d+1; i< arr.length; i++){
            System.err.print(arr[i]+" ");
        }
        System.err.println("Sum = "+prefix[d]);
    }
    
}
