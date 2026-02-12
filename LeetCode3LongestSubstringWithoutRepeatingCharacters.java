package HackerRankLeetCodeQuestions;
import java.util.HashMap;

public class LeetCode3LongestSubstringWithoutRepeatingCharacters {
    public static void main (String[] args) {

        // String s = "abcabcd";
        String s = "vdvf";


        int i = 0, j = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // map.put(0,-1);
        while(j < s.length()){

            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                maxLen = Math.max(maxLen, j - i + 1);
            
                j++;
                
            }else if(map.containsKey(s.charAt(j))){
                
            
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);

                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }

                    i++;
            

           

            }

        }
        
        System.err.println("maxLen: " + maxLen);
    }
}
