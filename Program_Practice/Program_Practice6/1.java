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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack s = new Stack();
        int sum = 0;
        List L = new ArrayList();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list;
        }
        L.add(root.val);
        dfs(s, root, targetSum, sum, list, L);
        return list;
    }
    public void dfs(Stack s, TreeNode node, int targetSum, int sum, List<List<Integer>> list, List L){
        if(node == null){
            return;
        }
        sum += node.val;
        if(sum == targetSum && node.left == null && node.right == null){
            List l = new ArrayList(L);
            list.add(l);
        }
        if(node.left != null){
            L.add(node.left.val);
            dfs(s, node.left, targetSum, sum, list, L);
            L.remove(L.size()-1);
        }
        if(node.right != null){
            L.add(node.right.val);
            dfs(s, node.right, targetSum, sum, list, L);
            L.remove(L.size()-1);
        }
    }
}