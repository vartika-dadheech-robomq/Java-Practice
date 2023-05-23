/*
Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
*/

//Approach 1 using queue (BFS) Tc - O(N), SC-O(N)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<List<Integer>>();
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<Integer>();
            int size = list.size();
            for (int i =0; i<size; i++) {
                root = list.remove();
                if (root != null) {
                if(root.left != null) list.add(root.left);
                if(root.right != null) list.add(root.right);
                levelNodes.add(root.val);
                }
            }
            if (!levelNodes.isEmpty()) traversal.add(levelNodes); 
            
            
        }
        return traversal;
    }
}

//Approach 2 using recursion Tc - O(N), SC-O(N)

class Solution {
    List<List<Integer>> traversal = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return traversal;
        addList(root, 0);
        return traversal;

    }

    public void addList (TreeNode root, int level) {
        if (traversal.size() == level) {
            traversal.add(new ArrayList<Integer>());
        }
        traversal.get(level).add(root.val);
        if(root.left != null) addList(root.left, level+1);
        if(root.right != null) addList(root.right, level+1);
    }
}