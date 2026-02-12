package HackerRankLeetCodeQuestions;

import java.util.HashMap;

public class LeetCode2958LengthOfLongestSubarrayWithAtMostKFrequency {

    public static void main(String[] args){

        int[] arr = {1,2,3,1,2,3,1,2};
        int k = 2;
        //output = 6;

        if (arr.length == k) {
            System.out.println("MaxLen: "+k);
        }else{

            HashMap<Integer, Integer> map = new HashMap<>();

            int i = 0, j = 0, maxLen = 0;

            while (j < arr.length) {

                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

                if(map.get(arr[j])==null || map.get(arr[j]) <= k){

                    maxLen = Math.max(maxLen, j - i  +1);

                    j++;
                
                }else if(map.get(arr[j]) > k){

                    while(map.get(arr[j]) > k){

                        map.put(arr[i], map.get(arr[i]) - 1);

                        i++;

                    }

                    j++;
                }
                
            }
            
            System.out.println("MaxLen: "+maxLen);
        }

        
    }
    
}
