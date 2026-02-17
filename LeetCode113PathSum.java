package HackerRankLeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113PathSum {

        // Definition for a binary tree node.
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        public static void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> currentPath, int targetSum){

            //Base Case:
            if(root == null) return;

            currentPath.add(root.val);

            if(root.left == null && root.right == null && root.val == targetSum){
                result.add(new ArrayList<>(currentPath));
                //copying the currentPath
            }

            pathSum(root.left, result, currentPath, targetSum - root.val);
            pathSum(root.right, result, currentPath, targetSum - root.val);

            //Backtracking
            currentPath.remove(currentPath.size() - 1); 
            //remove the last element as we back track for the new valid path;
        }

       public static void main(String[] args) {

        /*
            Example 1 Tree:

                    5
                   / \
                  4   8
                 /   / \
               11   13  4
              /  \      / \
             7    2    5   1
        */

        TreeNode root = new TreeNode(5);
        //Output: [[5, 4, 11, 2], [5, 8, 4, 5]];

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSum(root, lst, currentPath, targetSum);
        System.out.println(lst);
    }
    
}
