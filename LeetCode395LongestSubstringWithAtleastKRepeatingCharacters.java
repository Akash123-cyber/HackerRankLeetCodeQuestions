package HackerRankLeetCodeQuestions;

public class LeetCode395LongestSubstringWithAtleastKRepeatingCharacters {

    static int DivideAndConquer(String str, int start, int end, int k){

        //Base condition to stop the recursion
        if(end - start < k){ // because at this stage when our substring's length is less than K 
        // it can not have the required repeating charaters
            return 0;
        }

        //step1 : counting frequency of each character
        int[] freq = new int[26];
        for(int i = start; i < end; i++){
            freq[str.charAt(i) - 'a']++;
        }

        //step 2: Checking Validity of the Sub-String by traversing over freq array
        // for a substring to be valid it needs to contain only those characters
        // which have atleast k frequency

        boolean isValid = true;
        for(int i = 0; i < 26; i++){

            if(freq[i] > 0 && freq[i] < k){
                isValid = false;
            }
        }

        if (isValid) {//for a valid string we need to return its Length 
            return end - start;
        }

        
        //step3: finding the Invalid Character and Splitting the String 
        
        int maxLen = 0;
        int segmentStart = start;

        for(int i = start; i < end; i++){

            char c = str.charAt(i);


            if(freq[c - 'a'] < k){

                //Left Segment before this Invalid character
                maxLen = Math.max(maxLen, DivideAndConquer(str, segmentStart, i, k));

                // Moving start to next position after invalid character
                segmentStart = i + 1;

            }

        }
        
        //Right Segment After this Invalid Character
        maxLen = Math.max(maxLen, DivideAndConquer(str, segmentStart, end,k));

        return maxLen;


    }

    public static void main(String[] args){
    //we need to find the length of the longest substring have atleast K characters

    
        String s = "ababbc";

        int k = 2;

        if (s == null || s.length() < k) {
            System.err.println("Max Len: "+0);
        }else{
            
                    int maxLen = DivideAndConquer(s, 0, s.length(), k);
            
                    System.out.println("MaxLen: "+maxLen);


        }


    }
    
}
