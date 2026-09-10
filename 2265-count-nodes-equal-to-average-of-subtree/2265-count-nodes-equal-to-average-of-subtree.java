/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return count;
    }
    int[] solve(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left=solve(root.left);
        int[] right=solve(root.right);
        int sum=root.val+left[0]+right[0];
        int nodes=1+left[1]+right[1];
        if(sum/nodes==root.val){
            count++;
        }
        return new int[]{sum,nodes};
    }
}