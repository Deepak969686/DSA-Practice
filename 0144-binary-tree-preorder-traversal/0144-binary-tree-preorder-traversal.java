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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            } else{
                TreeNode pred=curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;
                    ans.add(curr.val);
                    curr = curr.left;
                } else{
                    pred.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}



// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans=new ArrayList<>();
//         preorder(ans,root);
//         return ans;
//     }
//     private void preorder(List<Integer> ans,TreeNode root){
//         if(root==null) return;
//         ans.add(root.val);
//         preorder(ans,root.left);
//         preorder(ans,root.right);
//     }
// }