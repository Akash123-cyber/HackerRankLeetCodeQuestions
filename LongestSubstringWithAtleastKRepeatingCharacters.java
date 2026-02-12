package HackerRankLeetCodeQuestions;
import java.util.HashMap;

public class LongestSubstringWithAtleastKRepeatingCharacters {

    static boolean isValid(String str, int i, int j, int k){

        HashMap<Character, Integer> map1 = new HashMap<>();


        for(int p = i; p <= j; p++){
            map1.put(str.charAt(p), map1.getOrDefault(str.charAt(p), 0)+1);

        }

        for(int v : map1.values()){
            if (v<k) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args){


        // String str = "acbcbabcbccbd";
        // String str = "aaabb";
        String str = "baaabcb";
        // String str = "bbaaacbd";
        int k = 3;
        

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()){

            map.put(c, map.getOrDefault(c,0)+1);
        }

        int i = 0, j = 0, maxLen = 0;

        while(j < str.length()){


            if (map.get(str.charAt(j)) < k) {

                while(i <= j){

                if(isValid(str, i, j - 1, k)){ //valid window is from i to j - 1
                    
                    maxLen = (maxLen > (j - i))? maxLen: (j - i);
                }
                i++;
            }
                
                j++;

            }else{

                if(isValid(str, i, j , k)){ //valid window is from i to j - 1
                    
                    maxLen = (maxLen > (j - i + 1))? maxLen: (j - i + 1);
                }
                j++;
            }
        }

        System.out.println("MaxLen: "+maxLen);


        
    }
}
