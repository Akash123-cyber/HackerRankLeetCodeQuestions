package HackerRankLeetCodeQuestions;

public class LeetCode129SumRoottoLeafNumbers {

    static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val =val;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumNumbers(TreeNode root, int currentSum, int totalSum){

        if(root == null) return 0;

        currentSum = currentSum * 10 + root.val; //4 * 10 + 9 = 49

        if(root.left == null && root.right == null){
            totalSum += currentSum;
        }

        totalSum += sumNumbers(root.left, currentSum, totalSum) + sumNumbers(root.right, currentSum, totalSum);

        return totalSum;
    }

    public static void main(String[] args) {

        /*
            Constructing Tree for Example 2:

                    4
                   / \
                  9   0
                 / \
                5   1
        */

        // Output should be: 1026;

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);


        int result = sumNumbers(root, 0 ,0);

        // Print Output
        System.out.println("Sum of Root-to-Leaf Numbers: " + result);
    }
    
}
