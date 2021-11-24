/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //层次遍历
        if(root == null) return root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        root.next = null;
        int count = 1;
        while(!q.isEmpty()){
            for(int i = 0; i < count; i++){
                if(q.element().left != null){
                    q.add(q.element().left);
                }
                if(q.element().right != null){
                    q.add(q.element().right);
                }
                if(i+1 < count){
                    q.remove().next = q.element();
                }
                else{
                    q.remove().next = null;
                }
            }
            count*=2;
        }
        return root;
    }
}