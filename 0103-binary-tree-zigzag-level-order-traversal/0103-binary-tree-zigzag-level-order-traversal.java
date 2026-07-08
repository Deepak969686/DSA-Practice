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
        if (root == null) return ans;
        Deque<TreeNode> dq=new LinkedList<>();
        dq.offerFirst(root);
        boolean LTR=true;
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(LTR){
                    TreeNode node=dq.pollFirst();
                    level.add(node.val);
                    if(node.left!=null){
                        dq.offerLast(node.left);
                    }
                    if(node.right!=null){
                        dq.offerLast(node.right);
                    }
                } else{
                    TreeNode node=dq.pollLast();
                    level.add(node.val);
                    if(node.right!=null){
                        dq.offerFirst(node.right);
                    }
                    if(node.left!=null){
                        dq.offerFirst(node.left);
                    }

                }
            }
            ans.add(level);
            LTR = !LTR;
        }
        return ans;
    }
}