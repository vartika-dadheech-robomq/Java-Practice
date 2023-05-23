/*
Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []
*/

//My solution O(N) O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> list = new LinkedList<>();
        if (root == null) return res;
        list.add(root);
        while(!list.isEmpty()) {
            int last = 0;
            int size = list.size();
            for(int i=0; i<size;i++) {
                root = list.remove();
                if (root != null) {
                last = root.val;
                if (root.left != null) list.add(root.left);
                if (root.right != null) list.add(root.right); 
              }
            }
            res.add(last);
        }
        return res;
    }
}
