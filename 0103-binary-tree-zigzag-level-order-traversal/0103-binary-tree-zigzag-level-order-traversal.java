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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);
        boolean LTR=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            while(size-->0){
                if(LTR){
                    TreeNode node=q.poll();
                    list.add(node.val);
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                } else{
                    TreeNode node=q.poll();
                    list.add(node.val);
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                   
                }
            }
            if(!LTR)  Collections.reverse(list);
            ans.add(list);
            LTR=!LTR;
        }
        return ans;
    }
}