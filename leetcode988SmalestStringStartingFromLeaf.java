package HackerRankLeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class leetcode988SmalestStringStartingFromLeaf {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    public static void lexSmallest(TreeNode root, List<Character> candidate, List<Character> result, boolean isCSmaller, boolean isRSmaller){

        if(root == null) return; //base condition

        candidate.add((char) (root.val + 'a'));

        if(root.left == null && root.right == null){

            if(result.size() ==0){
                result.addAll(candidate);
            }else{

                //initially both 
                //isCSmaller and isRSmaller are true;

                int i = candidate.size() - 1; 
                int j = result.size() - 1;

                while(i >= 0 && j >= 0){

                    if(candidate.get(i) < result.get(j)){
                        isCSmaller = true;
                        isRSmaller = false;
                        break;
                    }else if(candidate.get(i) > result.get(j)){
                        isCSmaller = false;
                        isRSmaller = true;
                        break;
                    }

                    i--;
                    j--;


                }

                if(isCSmaller && isRSmaller && (candidate.size() < result.size()) ){
                    
                
                    result.clear();
                    result.addAll(candidate);
                    
                }else if(isCSmaller && !isRSmaller){
                    result.clear();
                    result.addAll(candidate);
                }
            }
        }

        lexSmallest(root.left, candidate, result, isCSmaller, isRSmaller);
        lexSmallest(root.right, candidate, result, isCSmaller, isRSmaller);


        //backtracking
        candidate.remove(candidate.size() -1);
    }


    public static void main(String[] args) {

        /*
        Example 1:
        Input: root = [0,1,2,3,4,3,4]

                0
              /   \
             1     2
            / \   / \
           3  4  3  4
        */

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

                /*
        Example 3:
        Input: root = [2,2,1,null,1,0,null,0]

                2
               / \
              2   1
               \  /
                1 0
               /
              0
        */

        TreeNode root1 = new TreeNode(2);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(1);

        root1.left.right = new TreeNode(1);
        root1.left.right.left = new TreeNode(0);

        root1.right.left = new TreeNode(0);

        
    //we need to find the lexicographically smallest string that starts at a leaf
    //to compare the strings like abc and abcc i need to use the two variables to compare the strings
    // isCSmaller and isRSmaller and two lists candidate  and result

    List<Character> candidate = new ArrayList<Character>();
    List<Character> result = new ArrayList<Character>();
    boolean isCSmaller = true;
    boolean isRSmaller = true;

    lexSmallest(root1, candidate, result, isCSmaller, isRSmaller);
    

    //using string builder to convert the char list to string 
    //and for efficient use initialize the string builder to the size of
    //result list
    StringBuilder sb = new StringBuilder(result.size());

    for(int i = result.size() - 1; i>=0; i--){
        sb.append(result.get(i));
    }

    System.out.println(sb);

}    
}
