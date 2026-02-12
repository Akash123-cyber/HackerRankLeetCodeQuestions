package HackerRankLeetCodeQuestions;
import java.util.HashMap;

public class SubstringWithoutRepeatingCharacters {
    

    public static void main(String[] args){

        // String s = "eeydgwdykpv";
        String s = "abcabcd";

        int i = 0, j = 0, maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(j < s.length()){

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);

            if(map.size() < j - i +1){//map size less than window size meaning 
                // map contains repeating character

                while (map.size() < j - i + 1) {
                    
                    map.put(s.charAt(i),map.get(s.charAt(i))- 1);
                    
                    if(map.get(s.charAt(i))== 0){
                        map.remove(s.charAt(i));
                    }

                    i++;
                }

                j++;

            }else if(map.size() == j - i + 1){//when map size is equal to window size
            // meaning no repeating characters in the window

                maxLen = (maxLen > j - i + 1)? maxLen : j - i + 1;

                j++;
            }
            
        }

        System.out.println("MaxLen: "+maxLen);
        System.out.println(s.substring(i, j));
        
    }
}
