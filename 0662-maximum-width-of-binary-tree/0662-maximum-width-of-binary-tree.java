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
class Pair{
    TreeNode node;
    long index;
    Pair(TreeNode n,long i){
        this.node=n;
        this.index=i;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Deque<Pair> dq = new LinkedList<>();
        dq.offerLast(new Pair(root, 0));
        long maxwidth=0;
        while(!dq.isEmpty()){
            long size=dq.size();
            long left=dq.peekFirst().index;
            long right=dq.peekLast().index;
            maxwidth=Math.max(maxwidth,right-left+1);
            while(size-->0){
                Pair curr=dq.pollFirst();
                TreeNode node=curr.node;
                long index=curr.index;
                if(node.left!=null){
                    dq.offerLast(new Pair(node.left, 2 * index + 1));
                }
                if(node.right!=null){
                    dq.offerLast(new Pair(node.right, 2 * index + 2));
                }
            }
        }
        return (int)maxwidth;
    }
}